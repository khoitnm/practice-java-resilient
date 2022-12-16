package org.tnmk.practicejson.pro01springresilient4jmainmodule.sample_rest;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest.SubModuleService;

@Service
@RequiredArgsConstructor
public class MainModuleService {
  private final SubModuleService subModuleService;
  public String welcome(boolean success) {
    return subModuleService.welcome(success);
  }
}
