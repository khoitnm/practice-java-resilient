package org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubModuleService {

  @Retry(name = "SubModuleService")
  public String welcome(boolean success) {
    String result = String.format("Welcome_%s_%s",success, System.nanoTime());
    log.info("SubModuleService: " + result);
    if (!success) {
      throw new IllegalArgumentException("SubModuleService error when success = false");
    } else {
      return result;
    }
  }
}
