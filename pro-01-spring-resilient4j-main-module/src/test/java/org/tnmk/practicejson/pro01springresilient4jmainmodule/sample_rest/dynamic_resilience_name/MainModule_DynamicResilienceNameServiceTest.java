package org.tnmk.practicejson.pro01springresilient4jmainmodule.sample_rest.dynamic_resilience_name;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tnmk.practicejson.pro01springresilient4jmainmodule.testinfra.BaseIntegrationTest;

@Slf4j
public class MainModule_DynamicResilienceNameServiceTest extends BaseIntegrationTest {
  @Autowired
  private MainModule_DynamicResilienceNameService mainModuleService;

  @Test
  void test_success() throws Exception {
    Assertions.assertNotNull(mainModuleService.welcome_resilienceWithMethodNameAndArgument(true));
    Assertions.assertNotNull(mainModuleService.welcome_resilienceWithBeanName(true));
  }

  @Test
  void test_fail() throws Exception {
    try {
      mainModuleService.welcome_resilienceWithMethodNameAndArgument(false);
      mainModuleService.welcome_resilienceWithBeanName(false);

      Assertions.fail("The above method should get exception");
    } catch (Exception ex) {
      log.info("Expected exception: " + ex.getMessage());
    }
  }
}
