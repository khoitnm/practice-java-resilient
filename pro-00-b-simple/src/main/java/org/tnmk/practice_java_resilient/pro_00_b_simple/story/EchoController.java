package org.tnmk.practice_java_resilient.pro_00_b_simple.story;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EchoController {
  @GetMapping("/echo")
  public String echo(@RequestParam String message) {
    String echo = "Echo from pro-00-b-simple: " + message;
    log.info(echo);
    return echo;
  }
}
