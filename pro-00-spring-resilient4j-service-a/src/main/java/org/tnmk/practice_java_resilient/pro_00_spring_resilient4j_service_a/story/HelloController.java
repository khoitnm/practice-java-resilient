package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.story;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private final EchoClient echoClient;

  public HelloController(EchoClient echoClient) {
    this.echoClient = echoClient;
  }

  @GetMapping("/hello")
  public String hello(){
    return echoClient.echo("Hello from pro-00-spring-resilient4j-service-a");
  }

  @GetMapping("/hello/internal-error")
  public String helloWithInternalError(){
    return echoClient.echoWithServerInternalError();
  }

  @GetMapping("/hello/slow/{seconds}")
  public String helloSlow(@PathVariable Integer seconds){
    return echoClient.echoSlow(seconds);
  }
}
