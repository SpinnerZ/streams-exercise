package org.example.fipe_java_streams.service.implementation;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import org.example.fipe_java_streams.model.Ano;
import org.example.fipe_java_streams.model.Marca;
import org.example.fipe_java_streams.model.Modelos;
import org.example.fipe_java_streams.model.Veiculo;
import org.example.fipe_java_streams.service.FipeConsumer;
import org.example.fipe_java_streams.service.JsonConverter;

public class DeividFortunaFipeConsumer implements FipeConsumer {

  private static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
  HttpClient client = HttpClient.newHttpClient();
  HttpRequest request;
  JsonConverter jsonConverter = new JacksonJsonConverter();

  @Override
  public List<Marca> getMarcas(String tipoVeiculo) {

    var url = BASE_URL + tipoVeiculo + "/marcas";

    var json = fetchAPI(url).body();

    return jsonConverter.fromList(json, Marca.class);
  }

  @Override
  public Modelos getModelos(String tipoVeiculo, String codigoMarca) {

    var url = BASE_URL + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos";

    var json = fetchAPI(url).body();

    return jsonConverter.fromJson(json, Modelos.class);
  }

  @Override
  public List<String> getAnos(String tipoVeiculo, String codigoMarca, String codigoModelo) {

    var url =
        BASE_URL + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";

    var json = fetchAPI(url).body();

    return jsonConverter.fromList(json, Ano.class).stream().map(Ano::codigo).toList();
  }

  @Override
  public List<Veiculo> getVeiculos(
      String tipoVeiculo, String codigoMarca, String codigoModelo, List<String> anos) {

    String url =
        BASE_URL + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/";

    return anos.stream()
        .map(ano -> url + ano)
        .map(this::fetchAPI)
        .map(HttpResponse::body)
        .map(json -> jsonConverter.fromJson(json, Veiculo.class))
        .toList();
  }

  private HttpResponse<String> fetchAPI(String url) {

    request = HttpRequest.newBuilder().uri(URI.create(url)).build();

    try {
      return client.send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
