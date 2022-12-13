package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_b.common.error;

import lombok.Data;

@Data
public class ErrorResponse {
  private String errorCode;
  private String errorMessage;
  /**
   * Please don't use any object that has circular reference. Otherwise, a stackoverflow exception may occurs.
   */
  private Object details;
}
