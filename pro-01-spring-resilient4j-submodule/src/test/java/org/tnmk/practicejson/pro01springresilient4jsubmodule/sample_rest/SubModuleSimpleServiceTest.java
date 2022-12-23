package org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tnmk.practicejson.pro01springresilient4jsubmodule.sample_rest.simple.SubModule_SimpleService;
import org.tnmk.practicejson.pro01springresilient4jsubmodule.testinfra.BaseIntegrationTest;

public class SubModuleSimpleServiceTest extends BaseIntegrationTest {

  @Autowired
  private SubModule_SimpleService subModuleSimpleService;

  @Test
  void test_api() {
    Assertions.assertNotNull(subModuleSimpleService.welcome(true));
  }
}
