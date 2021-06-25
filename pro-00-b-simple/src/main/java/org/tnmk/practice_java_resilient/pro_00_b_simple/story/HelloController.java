package org.tnmk.practice_java_resilient.pro_00_b_simple.story;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
  @GetMapping("/hello")
  public String hello() {
    String message = "Hello from pro-00-b-simple";
    log.info(message);
    return message;
  }
}
