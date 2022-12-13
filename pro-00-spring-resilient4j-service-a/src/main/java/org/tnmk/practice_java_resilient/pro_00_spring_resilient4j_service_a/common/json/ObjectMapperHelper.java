package org.tnmk.practice_java_resilient.pro_00_spring_resilient4j_service_a.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface ObjectMapperHelper {
  static <T> T readValue(ObjectMapper objectMapper, String jsonString, Class<T> clazz) {
    try {
      return objectMapper.readValue(jsonString, clazz);
    } catch (JsonProcessingException e) {
      throw new IllegalStateException("Cannot convert jsonString to class " + clazz, e);
    }
  }
}
