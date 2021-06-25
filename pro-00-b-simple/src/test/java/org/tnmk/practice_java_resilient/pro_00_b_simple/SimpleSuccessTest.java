package org.tnmk.practice_java_resilient.pro_00_b_simple;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.tnmk.practice_java_resilient.pro_00_b_simple.story.SimpleLogWriting;

@SpringBootTest
public class SimpleSuccessTest {

    private SimpleLogWriting simpleLogWriting = new SimpleLogWriting();

    @Test
    public void when_writeLog_then_noException() {
        simpleLogWriting.writeHello();
    }

}
