package org.example.fipe_java_streams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(List<Modelo> modelos) {}
