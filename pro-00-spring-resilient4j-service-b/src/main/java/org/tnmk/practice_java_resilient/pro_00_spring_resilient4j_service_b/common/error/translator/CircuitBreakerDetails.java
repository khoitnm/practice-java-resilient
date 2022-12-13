package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_b.common.error.translator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CircuitBreakerDetails {
  private String circuitBreakerName;
}
