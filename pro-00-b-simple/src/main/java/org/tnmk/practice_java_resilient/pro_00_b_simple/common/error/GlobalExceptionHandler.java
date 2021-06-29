package org.tnmk.practice_java_resilient.pro_00_b_simple.common.error;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.tnmk.practice_java_resilient.pro_00_b_simple.common.error.translator.CircuitBreakerTranslator;
import org.tnmk.practice_java_resilient.pro_00_b_simple.common.error.translator.GeneralTranslator;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({
      CallNotPermittedException.class
  })
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorResponse handleHttpClientErrorException(CallNotPermittedException ex) {
    ErrorResponse errors = CircuitBreakerTranslator.toErrorResponse(ex);
    logError(errors, ex);
    return errors;
  }

  /**
   * Any unhandled exception will be considered as Internal error
   * @param ex The exception that was thrown.
   * @return The error response.
   */
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public ErrorResponse handleUnknownInternalException(Exception ex) {
    ErrorResponse errors = GeneralTranslator.toErrorResponse(ex);
    logError(errors, ex);
    return errors;
  }

  private void logError(ErrorResponse errorResponse, Throwable ex) {
    String errorMessage = String.join("",
        ex.getLocalizedMessage(), "\n ErrorResponse: ", String.valueOf(errorResponse));
    log.error(errorMessage, ex);
  }
}
