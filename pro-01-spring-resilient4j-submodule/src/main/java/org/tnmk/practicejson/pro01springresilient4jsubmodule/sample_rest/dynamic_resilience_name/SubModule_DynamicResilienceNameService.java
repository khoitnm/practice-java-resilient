package org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest.dynamic_resilience_name;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SubModule_DynamicResilienceNameService {
  private final SubModule_DynamicResilienceNameResolver subModule_dynamicResilienceNameResolver;

  // You can see details way to configure spelExpression for Retry in
  // SpelRootObject and io.github.resilience4j.spelresolver.SpelResolver.resolve
  // As we see, that SpelRootObject only has 2 usable fields: `methodName` and `args`
  @Retry(name = "#root.methodName + #root.args[0]")
  public String welcome_resilienceWithMethodNameAndArgument(boolean success) {
    String result = String.format("Welcome_%s_%s",success, System.nanoTime());
    log.info("SubModule_DynamicResilienceNameService : " + result);
    if (!success) {
      throw new IllegalArgumentException("SubModule_DynamicResilienceNameService error when success = false");
    } else {
      return result;
    }
  }

  @Retry(name = "#{subModule_DynamicResilienceNameResolver.resilienceName()}")
  public String welcome_resilienceWithBeanName(boolean success) {
    String result = String.format("Welcome_%s_%s",success, System.nanoTime());
    log.info("SubModule_DynamicResilienceNameService : " + result);
    if (!success) {
      throw new IllegalArgumentException("SubModule_DynamicResilienceNameService error when success = false");
    } else {
      return result;
    }
  }
}
