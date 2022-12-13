package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.web.server.LocalManagementPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.story.EchoClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // Without this, we cannot inject MockMvc
public class SimpleSuccessTest {
  @Autowired
  private EchoClient echoClient;

  @LocalManagementPort
  int randomManagementPort;

  @Test
  public void when_writeLog_then_noException() {
    echoClient.echo("Message" + System.nanoTime());
  }

}
