package org.example.fipe_java_streams.controller;

import java.util.Scanner;
import org.example.fipe_java_streams.enums.TipoVeiculo;
import org.example.fipe_java_streams.service.FipeConsumer;
import org.example.fipe_java_streams.service.implementation.DeividFortunaFipeConsumer;

public class TerminalUserInterface {

  Scanner scanner = new Scanner(System.in);
  FipeConsumer api = new DeividFortunaFipeConsumer();

  public void menuInicial() {

    System.out.println(
        """
           Bem vindo ao avaliador de preços de carros da tabela FIPE!

           *** OPÇÕES ***
           Carro
           Moto
           Caminhão

           Digite uma das opções para consulta:""");
    var option = scanner.nextLine();

    var tipoVeiculo = TipoVeiculo.fromOption(option).getTipo();
    var marcas = api.getMarcas(tipoVeiculo);

    System.out.println("Marcas disponíveis:");
    marcas.forEach(System.out::println);
    System.out.println("Insira o código da marca para continuar:");
    var marca = scanner.nextLine();
    var modelos = api.getModelos(tipoVeiculo, marca);

    System.out.println("Modelos disponíveis:");
    modelos.modelos().forEach(System.out::println);
    System.out.println("Filtre os resultados inserindo o nome do modelo:");
    var filtro = scanner.nextLine().toLowerCase();
    modelos.modelos().stream()
        .filter(m -> m.nome().toLowerCase().contains(filtro))
        .forEach(System.out::println);
    System.out.println("Insira o código do modelo para continuar:");
    var modelo = scanner.nextLine();

    var anos = api.getAnos(tipoVeiculo, marca, modelo);
    var veiculos = api.getVeiculos(tipoVeiculo, marca, modelo, anos);

    System.out.println("Todos os veículos filtrados com avaliações por ano:");
    veiculos.forEach(System.out::println);
  }
}
