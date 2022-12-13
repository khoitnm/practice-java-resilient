package org.tnmk.practice_java_resilient.pro_00_java_resilient4j_simple_retry.story;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloService {


  public void execute(boolean success) throws HelloServiceException {
    if (success) {
      log.info("execute success");
    } else {
      log.info("will throw exception");
      throw new HelloServiceException("test exception");
    }
  }


}
