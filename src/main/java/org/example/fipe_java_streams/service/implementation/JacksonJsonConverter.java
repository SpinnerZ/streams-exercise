package org.example.fipe_java_streams.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.util.List;
import org.example.fipe_java_streams.service.JsonConverter;

public class JacksonJsonConverter implements JsonConverter {

  private ObjectMapper mapper = new ObjectMapper();

  @Override
  public <T> T fromJson(String json, Class<T> clazz) {
    try {
      return mapper.readValue(json, clazz);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public <T> List<T> fromList(String json, Class<T> clazz) {
    CollectionType list = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
    try {
      return mapper.readValue(json, list);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
