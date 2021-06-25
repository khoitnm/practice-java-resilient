package org.tnmk.practice_java_resilient.pro_00_a_simple.story;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ServiceBClient {

  @Value("${serviceB.host}")
  private String serviceBHost;

  private final RestTemplate restTemplate;

  public ServiceBClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  public void writeHello() {
    ResponseEntity<String> responseEntity = restTemplate.getForEntity(serviceBHost + "/hello", String.class);
    log.info("Response from serviceB: {}", responseEntity.getBody());
  }
}
