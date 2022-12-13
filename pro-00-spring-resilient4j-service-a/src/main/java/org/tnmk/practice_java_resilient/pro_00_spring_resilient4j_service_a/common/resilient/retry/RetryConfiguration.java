package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.common.resilient.retry;

import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.common.resilient.ResilientSupport.SERVICE_HELLO;

@Configuration
public class RetryConfiguration {

  @Bean
  public RetryRegistry retryRegistry(RetryOnExceptionPredicate retryOnExceptionPredicate) {
    RetryConfig helloRetryConfig = helloRetryConfig(retryOnExceptionPredicate);

    // Note: this configuration code looks cleaner, but it doesn't work, I don't know why???
//    RetryRegistry retryRegistry = RetryRegistry.custom()
//        .addRetryConfig(SERVICE_HELLO, helloRetryConfig)
//        .build();

    RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
    retryRegistry.retry(SERVICE_HELLO, helloRetryConfig);
    return retryRegistry;
  }

  private RetryConfig helloRetryConfig(RetryOnExceptionPredicate retryOnExceptionPredicate){
    IntervalFunction intervalWithExponentialBackoff = IntervalFunction
        .ofExponentialBackoff(1000, 2.5d);

    RetryConfig retryConfig = RetryConfig.custom()
        .maxAttempts(2)
        .intervalFunction(intervalWithExponentialBackoff)
        .retryOnException(retryOnExceptionPredicate)
        .build();
    return retryConfig;
  }
}
