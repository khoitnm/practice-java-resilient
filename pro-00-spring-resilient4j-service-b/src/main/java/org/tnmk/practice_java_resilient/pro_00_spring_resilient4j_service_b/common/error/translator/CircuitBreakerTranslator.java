package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_b.common.error.translator;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_b.common.error.ErrorCodes;
import org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_b.common.error.ErrorResponse;

/**
 * This class is used to transform an exception to the {@link ErrorResponse} in a general way.<br/>
 * If you want to transform an exception in a more specific way,
 * please create another translator class for that specific Exception.
 */
public interface CircuitBreakerTranslator {
  static ErrorResponse toErrorResponse(CallNotPermittedException ex) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setErrorCode(ErrorCodes.CIRCUIT_BREAKER);
    errorResponse.setErrorMessage(ex.getMessage());
    CircuitBreakerDetails details = new CircuitBreakerDetails(ex.getCausingCircuitBreakerName());
    errorResponse.setDetails(details);
    return errorResponse;
  }
}
