package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.story;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class EchoClientConfig {
  @Value("${echo.host}")
  private String host;
}
