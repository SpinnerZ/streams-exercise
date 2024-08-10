package org.example.fipe_java_streams.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(
    @JsonAlias("Marca") String marca,
    @JsonAlias("Modelo") String modelo,
    @JsonAlias("AnoModelo") int anoModelo,
    @JsonAlias("Valor") String valor,
    @JsonAlias("Combustivel") String combustivel) {

  @Override
  public String toString() {
    return String.format(
        "%s %s ano: %d valor: %s combustível: %s", marca, modelo, anoModelo, valor, combustivel);
  }
}
