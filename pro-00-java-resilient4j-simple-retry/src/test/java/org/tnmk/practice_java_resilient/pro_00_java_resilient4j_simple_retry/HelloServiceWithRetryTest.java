package org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.story.HelloServiceException;
import org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.story.HelloServiceWithRetry;

public class HelloServiceWithRetryTest extends BaseStandaloneTest {

  @Autowired
  private HelloServiceWithRetry helloServiceWithRetry;

  @Test
  public void test() throws Exception {
    int expectRetryCount = 5;
    int counterBeforeRunning = helloServiceWithRetry.getRetryCounter();
    try {
      helloServiceWithRetry.executeWithRetry(expectRetryCount, false);
    } catch (HelloServiceException helloServiceException) {
      int counterAfterRunning = helloServiceWithRetry.getRetryCounter();
      int totalActualRetry = counterAfterRunning - counterBeforeRunning;
      Assertions.assertEquals(totalActualRetry, expectRetryCount);
    }
  }
}
