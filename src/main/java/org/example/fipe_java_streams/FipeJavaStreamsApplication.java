package org.example.fipe_java_streams;

import org.example.fipe_java_streams.controller.TerminalUserInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeJavaStreamsApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(FipeJavaStreamsApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    TerminalUserInterface tui = new TerminalUserInterface();
    tui.menuInicial();
  }
}
