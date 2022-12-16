package org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tnmk.practicejson.pro01springresilient4jsubmodule.testinfra.BaseIntegrationTest;

public class SubModuleServiceTest extends BaseIntegrationTest {

  @Autowired
  private SubModuleService subModuleService;

  @Test
  void test_api() {
    Assertions.assertNotNull(subModuleService.welcome(true));
  }
}
