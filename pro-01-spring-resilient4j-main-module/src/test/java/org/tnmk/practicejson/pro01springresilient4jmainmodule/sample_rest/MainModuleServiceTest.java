package org.tnmk.practicejson.pro01springresilient4jmainmodule.sample_rest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tnmk.practicejson.pro01springresilient4jmainmodule.testinfra.BaseIntegrationTest;

@Slf4j
public class MainModuleServiceTest extends BaseIntegrationTest {
  @Autowired
  private MainModuleService mainModuleService;

  @Test
  void test_success() throws Exception {
    Assertions.assertNotNull(mainModuleService.welcome(true));
  }

  @Test
  void test_fail() throws Exception {
    try {
      mainModuleService.welcome(false);
      Assertions.fail("The above method should get exception");
    } catch (Exception ex) {
      log.info("Expected exception: " + ex.getMessage());
    }
  }
}
