package org.tnmk.practice_java_resilient.pro_00_a_simple.story;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class EchoClient {

  @Value("${echo.host}")
  private String echoHost;

  private final RestTemplate restTemplate;

  public EchoClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public String echo(String message) {
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(echoHost + "/echo?message=" + message, String.class);
    String responseMessage = responseEntity.getBody();
    log.info("Response from echo: {}", responseMessage);
    return responseMessage;
  }
}
