package org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.common;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;

import java.time.Duration;

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

// Create a RetryRegistry with a custom global configuration
    RetryRegistry registry = RetryRegistry.of(defaultConfig);

    Retry retryWithDefaultConfig = registry.retry(retryName);
    return retryWithDefaultConfig;
  }
}
