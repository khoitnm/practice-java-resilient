package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.common.resilient.retry;

import lombok.Data;

import java.util.Map;

@Data
public class EchoErrorResponse {
  private String errorCode;
  private String errorMessage;
  private Map<String, Object> details;
}
