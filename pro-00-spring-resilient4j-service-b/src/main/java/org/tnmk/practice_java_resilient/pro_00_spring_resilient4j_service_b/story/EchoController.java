package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_b.story;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EchoController {

  @CircuitBreaker(name = ResilientSupport.SERVICE_ECHO)
  @GetMapping("/echo")
  public String echo(@RequestParam String message) {
    String echo = "Echo from pro-00-spring-resilient4j-service-b: " + message;
    log.info(echo);
    return echo;
  }

  @CircuitBreaker(name = ResilientSupport.SERVICE_ECHO)
  @GetMapping("/echo/internal-error")
  public String echoInternalError() {
    throw new UnsupportedOperationException("Internal error");
  }

  @CircuitBreaker(name = ResilientSupport.SERVICE_ECHO)
  @GetMapping("/echo/slow/{seconds}")
  public String echoSlow(@PathVariable Integer seconds) throws InterruptedException {
    log.info("Start Slow {}", seconds);
    Thread.sleep(seconds * 1000);
    log.info("End Slow {}", seconds);
    return "Slow";
  }
}
