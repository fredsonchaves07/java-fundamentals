package jdev.introducaoOrientacaoObjetos;

public class Aluno {

    String nome;

    int idade;

    String dataNascimento;

    String registroGeral;

    String numeroCPF;

    public Aluno() {

    }

    public Aluno(String nome, int idade, String dataNascimento, String registroGeral, String numeroCPF) {
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.registroGeral = registroGeral;
        this.numeroCPF = numeroCPF;
    }
}
