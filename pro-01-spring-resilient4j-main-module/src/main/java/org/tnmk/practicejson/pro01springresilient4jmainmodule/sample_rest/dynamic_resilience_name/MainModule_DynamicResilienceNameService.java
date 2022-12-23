package org.tnmk.practicejson.pro01springresilient4jmainmodule.sample_rest.dynamic_resilience_name;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest.dynamic_resilience_name.SubModule_DynamicResilienceNameService;

@Service
@RequiredArgsConstructor
public class MainModule_DynamicResilienceNameService {
  private final SubModule_DynamicResilienceNameService subModule_dynamicResilienceNameService;

  public String welcome_resilienceWithMethodNameAndArgument(boolean success) {
    return subModule_dynamicResilienceNameService.welcome_resilienceWithMethodNameAndArgument(success);
  }

  public String welcome_resilienceWithBeanName(boolean success) {
    return subModule_dynamicResilienceNameService.welcome_resilienceWithMethodNameAndArgument(success);
  }
}
