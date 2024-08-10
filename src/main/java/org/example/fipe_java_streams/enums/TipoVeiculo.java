package org.example.fipe_java_streams.enums;

import lombok.Getter;

public enum TipoVeiculo {
  CARROS,
  MOTOS,
  CAMINHOES;

  @Getter private String tipo;

  TipoVeiculo() {
    tipo = this.name().toLowerCase();
  }

  public static TipoVeiculo fromOption(String option) {

    if (option.toLowerCase().contains("car")) {
      return CARROS;
    } else if (option.toLowerCase().contains("mot")) {
      return MOTOS;
    } else if (option.toLowerCase().contains("cam")) {
      return CAMINHOES;
    }

    throw new IllegalArgumentException("Tipo de veículo não encontrado");
  }
}
