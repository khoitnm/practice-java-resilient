package org.tnmk.practice_java_resilient.pro_00_b_simple.common.error.translator;

import org.tnmk.practice_java_resilient.pro_00_b_simple.common.error.ErrorCodes;
import org.tnmk.practice_java_resilient.pro_00_b_simple.common.error.ErrorResponse;

/**
 * This class is used to transform an exception to the {@link ErrorResponse} in a general way.<br/>
 * If you want to transform an exception in a more specific way,
 * please create another translator class for that specific Exception.
 */
public interface GeneralTranslator {
  static ErrorResponse toErrorResponse(Exception ex) {
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setErrorCode(ErrorCodes.GENERAL_ERROR);
    errorResponse.setErrorMessage(ex.getMessage());
    return errorResponse;
  }
}
