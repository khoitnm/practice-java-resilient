package org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.story.HelloService;
import org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.story.HelloServiceException;
import org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.story.HelloServiceWithResilientCombined;

@Slf4j
public class HelloServiceWithResilientCombinedTest extends BaseStandaloneTest {

  @Test
  public void testRetry_CircuitBreakerOff() {
    HelloServiceWithResilientCombined helloServiceWithResilientCombined = new HelloServiceWithResilientCombined(
        5,
        7,
        new HelloService()
    );
    try {
      helloServiceWithResilientCombined.executeWithResilient(false);
      Assertions.fail("It shouldn't be success because the above argument `success = false`");
    } catch (HelloServiceException ex) {
      log.error(ex.getMessage(), ex);
    } catch (Exception ex) {
      Assertions.fail("The exception should be HelloServiceException because it reaches max retries, but the " +
          "actual exception is " + ex);
    }
  }

  @Test
  public void testRetry_CircuitBreakerOn() {
    HelloServiceWithResilientCombined helloServiceWithResilientCombined = new HelloServiceWithResilientCombined(
        5,
        4, // less than max retries -> circuit breaker on.
        new HelloService()
    );
    try {
      helloServiceWithResilientCombined.executeWithResilient(false);
      Assertions.fail("It shouldn't be success because the above argument `success = false`");
    } catch (CallNotPermittedException ex) {
      log.error(ex.getMessage(), ex);
    } catch (Exception ex) {
      Assertions.fail("The exception should be CallNotPermittedException because CircuitBreaker is OPEN, but the " +
          "actual exception is " + ex);
    }
  }
}
