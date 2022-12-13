package org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.story;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
import lombok.extern.slf4j.Slf4j;
import org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.common.ResilientFactory;

import java.util.function.Function;

@Slf4j
public class HelloServiceWithResilientCombined {
  private final Retry retry;
  private final CircuitBreaker circuitBreaker;

  private final HelloService helloService;

  public HelloServiceWithResilientCombined(int maxRetriesCount, int maxCircuitBreakerCount, HelloService helloService) {
    this.retry = ResilientFactory.retry(maxRetriesCount, "retryForHelloService");
    this.circuitBreaker = ResilientFactory.circuitBreaker(maxCircuitBreakerCount, "circuitBreakerForHelloService");
    this.helloService = helloService;
  }

  public void executeWithResilient(boolean success) {
    Function<Void, Void> mainFunction = (input) -> {
      log.info("helloService.execute({}) with resilient: starting...", success);
      helloService.execute(success);
      return null;
    };

    Function<Void, Void> decoratedSupplier = Decorators.ofFunction(mainFunction)
        .withCircuitBreaker(circuitBreaker)
        .withRetry(retry)
        .decorate();

    decoratedSupplier.apply(null);
  }
}
