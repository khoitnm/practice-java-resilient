package org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.story;

public class HelloServiceException extends RuntimeException {

  public HelloServiceException(String message) {
    super(message);
  }
}
