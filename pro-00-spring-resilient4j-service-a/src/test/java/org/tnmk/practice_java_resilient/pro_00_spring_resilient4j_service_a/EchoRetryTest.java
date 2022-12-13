package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.story.EchoClient;
import org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.story.EchoClientConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // Without this, we cannot inject MockMvc
public class EchoRetryTest {

  @LocalServerPort
  int randomServerPort;
  @MockBean
  private EchoClientConfig echoClientConfig;

  @Autowired
  private EchoClient echoClient;

  @Test
  public void when_callEchoFail_thenRetry() {
    Mockito.when(echoClientConfig.getHost()).thenReturn("localhost:" + randomServerPort);

    echoClient.echo("Message" + System.nanoTime());
  }

}
