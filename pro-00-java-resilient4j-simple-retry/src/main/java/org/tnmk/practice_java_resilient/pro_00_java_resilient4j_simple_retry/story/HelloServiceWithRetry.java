package org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.story;

import io.github.resilience4j.retry.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.common.ResilientFactory;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class HelloServiceWithRetry {
  private final AtomicInteger retryCounter = new AtomicInteger(0);
  private final HelloService helloService;

  public void executeWithRetry(int numOfRetries, boolean success) throws Exception {
    Retry retryWithDefaultConfig = ResilientFactory.retry(numOfRetries, "retryForHelloService");

    retryWithDefaultConfig.executeCallable(() -> {
      retryCounter.incrementAndGet();
      helloService.execute(success);
      return null;
    });
  }

  public int getRetryCounter() {
    return retryCounter.get();
  }
}
