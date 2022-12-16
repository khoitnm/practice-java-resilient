package org.tnmk.practicejson.pro01springresilient4jmainmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Pro01SpringResilient4jMainModuleApplication {

  public static void main(String[] args) {
    SpringApplication.run(Pro01SpringResilient4jMainModuleApplication.class, args);
  }
}
