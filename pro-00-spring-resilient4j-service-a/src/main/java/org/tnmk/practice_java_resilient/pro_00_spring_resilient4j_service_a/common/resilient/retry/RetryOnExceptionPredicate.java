package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.common.resilient.retry;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.common.json.ObjectMapperHelper;

import java.util.function.Predicate;

@Slf4j
@Component
public class RetryOnExceptionPredicate implements Predicate<Throwable> {

  private final ObjectMapper objectMapper;

  public RetryOnExceptionPredicate(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @Override public boolean test(Throwable throwable) {
    boolean isRetry = isCircuitBreakerError(throwable) || isDisconnected(throwable) || isHttp404(throwable);
    log.info("Retry: {}", isRetry);
    return isRetry;
  }

  private boolean isHttp404(Throwable throwable) {
    boolean result = (throwable instanceof HttpClientErrorException.NotFound);
    log.debug("Retry because of 404: {}", result);
    return result;
  }

  /**
   * Usually, this ConnectionException happens when the client already found the server, but the connect is refused.
   * To be more precise, the client app may already found the API, and the server is processing. But then the Server may suddenly shutdown,
   * or the connection is closed unexpectedly.
   */
  private boolean isDisconnected(Throwable throwable) {
    boolean result = throwable instanceof ResourceAccessException;
    log.debug("Retry because of disconnected: {}", result);
    return result;
  }

  private boolean isCircuitBreakerError(Throwable throwable) {
    boolean result;
    if (throwable instanceof HttpServerErrorException) {
      HttpServerErrorException httpServerErrorException = (HttpServerErrorException) throwable;
      String responseString = httpServerErrorException.getResponseBodyAsString();
      EchoErrorResponse errorResponse = ObjectMapperHelper.readValue(objectMapper, responseString, EchoErrorResponse.class);
      result = EchoErrorCodes.CIRCUIT_BREAKER.equals(errorResponse.getErrorCode());
    } else {
      result = false;
    }
    log.debug("Retry because of circuit breaker: {}", result);
    return result;
  }
}
