package org.tnmk.practice_java_resilient.pro_00_a_simple.story;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tnmk.practice_java_resilient.pro_00_a_simple.common.resilient.ResilientSupport;

@Slf4j
@Service
public class EchoClient {

  private final EchoClientConfig echoClientConfig;
  private final RestTemplate restTemplate;

  public EchoClient(EchoClientConfig echoClientConfig, RestTemplateBuilder restTemplateBuilder) {
    this.echoClientConfig = echoClientConfig;
    this.restTemplate = restTemplateBuilder.build();
  }

  @Retry(name = ResilientSupport.SERVICE_HELLO)
  public String echo(String message) {
    log.info("echo message "+message);
    String url = echoClientConfig.getHost() + "/echo?message=" + message;
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
    String responseMessage = responseEntity.getBody();
    log.info("Response from echo: {}", responseMessage);
    return responseMessage;
  }

  @Retry(name = ResilientSupport.SERVICE_HELLO)
  public String echoWithServerInternalError() {
    log.info("echoWithServerInternalError");
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(echoClientConfig.getHost() + "/echo/internal-error", String.class);
    String responseMessage = responseEntity.getBody();
    log.info("Response from echo: {}", responseMessage);
    return responseMessage;
  }

  @Retry(name = ResilientSupport.SERVICE_HELLO)
  public String echoSlow(int slowSeconds) {
    log.info("echoSlow");
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(echoClientConfig.getHost() + "/echo/slow/"+slowSeconds, String.class);
    String responseMessage = responseEntity.getBody();
    log.info("Response from echo: {}", responseMessage);
    return responseMessage;
  }
}
