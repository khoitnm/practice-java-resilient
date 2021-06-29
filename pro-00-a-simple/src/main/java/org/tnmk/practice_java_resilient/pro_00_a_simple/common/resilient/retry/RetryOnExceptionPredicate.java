package org.tnmk.practice_java_resilient.pro_00_a_simple.common.resilient.retry;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.tnmk.practice_java_resilient.pro_00_a_simple.common.json.ObjectMapperHelper;

import java.util.function.Predicate;

@Slf4j
@Component
public class RetryOnExceptionPredicate implements Predicate<Throwable> {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override public boolean test(Throwable throwable) {
    boolean isCircuitBreaker = isCircuitBreakerError(throwable);
    log.info("isCircuitBreaker: {}", isCircuitBreaker);
    return isCircuitBreaker;
  }

  private boolean isCircuitBreakerError(Throwable throwable) {
    if (!(throwable instanceof HttpServerErrorException)) {
      return false;
    }
    HttpServerErrorException httpServerErrorException = (HttpServerErrorException) throwable;
    String responseString = httpServerErrorException.getResponseBodyAsString();
    EchoErrorResponse errorResponse = ObjectMapperHelper.readValue(objectMapper, responseString, EchoErrorResponse.class);
    return EchoErrorCodes.CIRCUIT_BREAKER.equals(errorResponse.getErrorCode());
  }
}
