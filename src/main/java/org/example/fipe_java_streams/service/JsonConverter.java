package org.example.fipe_java_streams.service;

import java.util.List;

public interface JsonConverter {

  <T> T fromJson(String json, Class<T> clazz);

  <T> List<T> fromList(String json, Class<T> classe);
}
