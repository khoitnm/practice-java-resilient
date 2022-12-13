package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.common.resilient.retry.EchoErrorCodes;
import org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.common.resilient.retry.EchoErrorResponse;

@RestController
public class FakeEchoController {

  @GetMapping("/echo")
  @ResponseBody
  public EchoErrorResponse echo(@RequestParam String message) {
    EchoErrorResponse errorResponse = new EchoErrorResponse();
    errorResponse.setErrorCode(EchoErrorCodes.CIRCUIT_BREAKER);
    return errorResponse;
  }
}
