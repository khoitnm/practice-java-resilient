package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_simple_circuit_breaker.story;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_simple_circuit_breaker.common.rest.RestSupport;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final HelloService helloService;

  @GetMapping(RestSupport.API_PREFIX + "/hello")
  public String hello(@RequestParam(value = "success", required = false, defaultValue = "true") boolean success) {
    helloService.excecute(success);
    return "Finished";
  }
}
