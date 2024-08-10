package org.example.fipe_java_streams.model;

public record Modelo(int codigo, String nome) {

  @Override
  public String toString() {
    return nome + " : " + codigo;
  }
}
