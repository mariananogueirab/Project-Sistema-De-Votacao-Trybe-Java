package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  // um array com os objetos instanciados da classe PessoaCandidata
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  // um array com os objetos instanciados da classe PessoaEleitora
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  // Esse array é responsável por manter os CPFs das pessoas eleitoras que já votaram
  // cada pessoa eleitora só pode votar uma vez
  private int totalVotos = 0;

  /**
   * Construtor.
   */

  public GerenciamentoVotacao() {}

  /**
   * Método cadastrarPessoaCandidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    Boolean containNumber = false;
    // referencia stackoverflow:
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        containNumber = true;
      }
    }

    if (containNumber == false) {
      PessoaCandidata pessoa = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pessoa);
    }
  }

  /**
   * Método cadastrarPessoaEleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    // referencia stackoverflow: percorrer arrai de objetos
    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
      }
    }
    PessoaEleitora pessoa = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoa);
  }

  /**
   * Método votar.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    Boolean containCpfEleitor = cpfComputado.contains(cpfPessoaEleitora);

    if (containCpfEleitor == true) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
        if (pessoaCandidata.getNumero() == numeroPessoaCandidata) {
          pessoaCandidata.receberVoto();
        }
      }
      cpfComputado.add(cpfPessoaEleitora);
      totalVotos += 1;
    }
  }

  /**
   * Método calcularPorcentagemVotos.
   */
  private Double calcularPorcentagemVotos(int indice) {
    int votos = this.pessoasCandidatas.get(indice).getVotos();
    Double votosEmPorcentagem = (votos * 100.0) / totalVotos;
    return votosEmPorcentagem;
  }

  /**
   * Método mostrarResultado.
   */
  public void mostrarResultado() {
    if (totalVotos <= 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
        Double votosEmPorcentagem =
            this.calcularPorcentagemVotos(this.pessoasCandidatas.indexOf(pessoaCandidata));
        String nome = "Nome: " + pessoaCandidata.nome;
        String votosPorc = "( " + votosEmPorcentagem + " )";
        System.out.println(nome + " - " + pessoaCandidata.getVotos() + " votos " + votosPorc);
      }
      System.out.println("Total de votos: " + totalVotos);
    }
  }

}
