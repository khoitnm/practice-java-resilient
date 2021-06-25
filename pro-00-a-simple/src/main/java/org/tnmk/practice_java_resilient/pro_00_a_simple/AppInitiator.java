package org.tnmk.practice_java_resilient.pro_00_a_simple;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.tnmk.practice_java_resilient.pro_00_a_simple.story.EchoClient;

@Component
public class AppInitiator {
  private final EchoClient echoClient;

  public AppInitiator(EchoClient echoClient) {
    this.echoClient = echoClient;
  }

  @EventListener(ApplicationReadyEvent.class)
  public void ready() {
    echoClient.echo("Start" + System.nanoTime());
  }
}
