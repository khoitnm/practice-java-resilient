package org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.common;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class ResilientFactory {
  /**
   * Configure retry.
   *
   * @param retryCount
   * @param retryName
   * @return retry object with configured values.
   */
  public static Retry retry(int retryCount, String retryName) {
    RetryConfig defaultConfig = RetryConfig.custom()
        .maxAttempts(retryCount)
        .waitDuration(Duration.ofMillis(100))
        .build();

    RetryRegistry registry = RetryRegistry.of(defaultConfig);

    Retry retryWithDefaultConfig = registry.retry(retryName);
    return retryWithDefaultConfig;
  }

  public static CircuitBreaker circuitBreaker(int failureThreshold, String circuitBreakerName) {
    CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
//        .failureRateThreshold(failureThreshold)
        .waitDurationInOpenState(Duration.ofMillis(1000))
        .permittedNumberOfCallsInHalfOpenState(2)
        .slidingWindowSize(failureThreshold)
        .build();

// Create a CircuitBreakerRegistry with a custom global configuration
    CircuitBreakerRegistry circuitBreakerRegistry =
        CircuitBreakerRegistry.of(circuitBreakerConfig);

    CircuitBreaker circuitBreaker = circuitBreakerRegistry
        .circuitBreaker(circuitBreakerName);

    return circuitBreaker;
  }
}
