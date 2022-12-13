package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.common.resilient.retry;

/**
 * This interface should be the same as ErrorCodes.java in the Echo Service.
 */
public interface EchoErrorCodes {
  String GENERAL_ERROR = "0";
  String CIRCUIT_BREAKER = "1";
}
