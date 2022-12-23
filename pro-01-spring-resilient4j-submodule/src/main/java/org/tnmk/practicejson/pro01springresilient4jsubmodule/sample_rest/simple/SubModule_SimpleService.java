package org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest.simple;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubModule_SimpleService {

  @Retry(name = "SubModule_SimpleService")
  public String welcome(boolean success) {
    String result = String.format("Welcome_%s_%s",success, System.nanoTime());
    log.info("SubModule_SimpleService : " + result);
    if (!success) {
      throw new IllegalArgumentException("SubModule_SimpleService error when success = false");
    } else {
      return result;
    }
  }
}
