package org.example.fipe_java_streams.service;

import java.util.List;
import org.example.fipe_java_streams.model.Marca;
import org.example.fipe_java_streams.model.Modelos;
import org.example.fipe_java_streams.model.Veiculo;

public interface FipeConsumer {

  List<Marca> getMarcas(String tipoVeiculo);

  Modelos getModelos(String tipoVeiculo, String codigoMarca);

  List<String> getAnos(String tipoVeiculo, String codigoMarca, String codigoModelo);

  List<Veiculo> getVeiculos(
      String tipoVeiculo, String codigoMarca, String codigoModelo, List<String> anos);
}
