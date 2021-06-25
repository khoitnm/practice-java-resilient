package org.tnmk.practice_java_resilient.pro_00_a_simple;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tnmk.practice_java_resilient.pro_00_a_simple.story.ServiceBClient;

@SpringBootTest
public class SimpleSuccessTest {
    @Autowired
    private ServiceBClient serviceBClient;

    @Test
    public void when_writeLog_then_noException() {
        serviceBClient.writeHello();
    }

}
