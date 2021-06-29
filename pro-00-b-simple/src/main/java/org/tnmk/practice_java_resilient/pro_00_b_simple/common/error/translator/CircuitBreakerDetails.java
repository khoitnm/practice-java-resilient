package org.tnmk.practice_java_resilient.pro_00_b_simple.common.error.translator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CircuitBreakerDetails {
  private String circuitBreakerName;
}
