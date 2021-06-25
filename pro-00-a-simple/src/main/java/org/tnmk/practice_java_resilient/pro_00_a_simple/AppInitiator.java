package org.tnmk.practice_java_resilient.pro_00_a_simple;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.tnmk.practice_java_resilient.pro_00_a_simple.story.ServiceBClient;

@Component
public class AppInitiator {
    private final ServiceBClient serviceBClient;

    public AppInitiator(ServiceBClient serviceBClient) {
        this.serviceBClient = serviceBClient;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        serviceBClient.writeHello();
    }
}
