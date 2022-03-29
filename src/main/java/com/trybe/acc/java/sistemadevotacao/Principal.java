package main.java.com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  /**
   * Main.
   */
  public static void main(String[] args) {
    short opcaoCandidata;
    short opcaoEleitora;
    short opcaoVotacao;
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();
    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      String opcaoDigitada = scanner.next();
      opcaoCandidata = Short.parseShort(opcaoDigitada);

      if (opcaoCandidata == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidata = scanner.next();

        System.out.println("Entre com o número da pessoa candidata:");
        String number = scanner.next();
        int numberCandidate = Integer.parseInt(number);

        gerenciamento.cadastrarPessoaCandidata(nomeCandidata, numberCandidate);
      }

      if (opcaoCandidata == 2) {
        break;
      }
    } while (opcaoCandidata == 1);

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      String opcaoDigitada = scanner.next();
      opcaoEleitora = Short.parseShort(opcaoDigitada);

      if (opcaoEleitora == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitora = scanner.next();

        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();

        gerenciamento.cadastrarPessoaEleitora(nomeEleitora, cpf);
      }

      if (opcaoEleitora == 2) {
        break;
      }
    } while (opcaoEleitora == 1);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      String opcaoDigitada = scanner.next();
      opcaoVotacao = Short.parseShort(opcaoDigitada);

      if (opcaoVotacao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();

        System.out.println("Entre com o número da pessoa candidata:");
        String number = scanner.next();
        int numberCandidate = Integer.parseInt(number);

        gerenciamento.votar(cpf, numberCandidate);
      }

      if (opcaoVotacao == 2) {
        gerenciamento.mostrarResultado();
      }

      if (opcaoVotacao == 3) {
        gerenciamento.mostrarResultado();
        break;
      }
    } while (opcaoVotacao == 1);
    scanner.close();
  }

}
