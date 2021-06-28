package org.tnmk.practice_java_resilient.pro_00_a_simple.story;

import io.github.resilience4j.retry.annotation.Retry;
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

  @Retry(name = ResilientSupport.SERVICE_HELLO)
  public String echo(String message) {
    log.info("echo message "+message);
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(echoHost + "/echo?message=" + message, String.class);
    String responseMessage = responseEntity.getBody();
    log.info("Response from echo: {}", responseMessage);
    return responseMessage;
  }

//  @Retry(name = ResilientSupport.SERVICE_HELLO)
  public String echoWithServerInternalError() {
    log.info("echoWithServerInternalError");
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(echoHost + "/echo/internal-error", String.class);
    String responseMessage = responseEntity.getBody();
    log.info("Response from echo: {}", responseMessage);
    return responseMessage;
  }

  public String echoSlow(int slowSeconds) {
    log.info("echoSlow");
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(echoHost + "/echo/slow/"+slowSeconds, String.class);
    String responseMessage = responseEntity.getBody();
    log.info("Response from echo: {}", responseMessage);
    return responseMessage;
  }
}
