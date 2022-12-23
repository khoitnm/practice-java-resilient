package org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest.dynamic_resilience_name;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class SubModule_DynamicResilienceNameResolver {
  public String resilienceName() {
    return "A_" + ZonedDateTime.now().getDayOfMonth();
  }
}
