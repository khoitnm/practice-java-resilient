package org.tnmk.practicejson.pro01springresilient4jmainmodule.sample_rest.simple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest.simple.SubModule_SimpleService;

@Service
@RequiredArgsConstructor
public class MainModule_SimpleService {
  private final SubModule_SimpleService subModuleSimpleService;
  public String welcome(boolean success) {
    return subModuleSimpleService.welcome(success);
  }
}
