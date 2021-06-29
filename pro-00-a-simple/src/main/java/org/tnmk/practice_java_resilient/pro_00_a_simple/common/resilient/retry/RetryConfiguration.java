package org.tnmk.practice_java_resilient.pro_00_a_simple.common.resilient.retry;

import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

import static org.tnmk.practice_java_resilient.pro_00_a_simple.common.resilient.ResilientSupport.SERVICE_HELLO;

@Configuration
public class RetryConfiguration {

  @Bean
  public RetryRegistry retryRegistry(RetryOnExceptionPredicate retryOnExceptionPredicate) {
    //    RetryConfig existingHelloConfig = RetryRegistry.getConfiguration(SERVICE_HELLO).get();
    IntervalFunction intervalWithExponentialBackoff = IntervalFunction
        .ofExponentialBackoff(1000, 2.5d);

    RetryConfig retryConfig = RetryConfig.custom()
        .maxAttempts(3)
        .intervalFunction(intervalWithExponentialBackoff)
        .retryOnException(retryOnExceptionPredicate)
        .build();

    RetryRegistry retryRegistry = RetryRegistry.of(retryConfig);
    retryRegistry.retry(SERVICE_HELLO, retryConfig);
    return retryRegistry;
  }
}
