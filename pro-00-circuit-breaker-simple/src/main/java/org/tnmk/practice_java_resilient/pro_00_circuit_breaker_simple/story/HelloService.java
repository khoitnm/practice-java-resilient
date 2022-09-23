package org.tnmk.practice_java_resilient.pro_00_circuit_breaker_simple.story;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.tnmk.practice_java_resilient.pro_00_circuit_breaker_simple.common.resilient.ResilientSupport;

@Slf4j
@Service
public class HelloService {

  @CircuitBreaker(name = ResilientSupport.SERVICE_HELLO)
  public void excecute(boolean success) {
    if (success) {
      log.info("execute success");
    } else {
      throw new IllegalArgumentException("test failure");
    }
  }
}
