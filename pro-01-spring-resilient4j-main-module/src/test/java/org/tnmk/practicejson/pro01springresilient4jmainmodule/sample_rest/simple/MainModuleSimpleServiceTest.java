package org.tnmk.practicejson.pro01springresilient4jmainmodule.sample_rest.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tnmk.practicejson.pro01springresilient4jmainmodule.sample_rest.simple.MainModule_SimpleService;
import org.tnmk.practicejson.pro01springresilient4jmainmodule.testinfra.BaseIntegrationTest;

@Slf4j
public class MainModuleSimpleServiceTest extends BaseIntegrationTest {
  @Autowired
  private MainModule_SimpleService mainModuleSimpleService;

  @Test
  void test_success() throws Exception {
    Assertions.assertNotNull(mainModuleSimpleService.welcome(true));
  }

  @Test
  void test_fail() throws Exception {
    try {
      mainModuleSimpleService.welcome(false);
      Assertions.fail("The above method should get exception");
    } catch (Exception ex) {
      log.info("Expected exception: " + ex.getMessage());
    }
  }
}
