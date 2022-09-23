package org.tnmk.practice_java_resilient.pro_00_a_simple.story;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class EchoClientConfig {
  @Value("${echo.host}")
  private String host;
}
