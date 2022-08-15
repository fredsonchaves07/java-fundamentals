# Herança e Polimorfismo

## Introdução a Herança

- Permite a criação de novas classes a partir de outras já existentes
- As novas classes são chamadas de subclasses, ou classes derivasas; e as classes já existentes, que deram origem ás subclasses são chamadas de superclasses, classe base ou classe mãe
- É possível criar uma hierarquia (Classe genérica e específica)
- Uma subclasse herda métodos e atributos de sua superclasse
-![Captura de tela de 2022-08-15 10-03-11](https://user-images.githubusercontent.com/43495376/184640035-07aa9a0d-54db-4b59-be0c-94190167fbcd.png)
- Exemplo da superclasse

```java
public class Pessoa {

    protected String nome;
    protected int idade;
    protected String dataNascimento;
    protected String registroGeral;
    protected String numeroCPF;
    protected Pessoa pai;
    protected Pessoa mae;

    public Pessoa(String nome, int idade, String dataNascimento, String registroGeral, String numeroCPF, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.registroGeral = registroGeral;
        this.numeroCPF = numeroCPF;
        this.pai = pai;
        this.mae = mae;
    }
}
```

- Exemplo da classe que está herdando de `Pessoa`

```java
public class Aluno extends Pessoa {

    private double nota1;

    private double nota2;

    public Aluno(String nome, int idade, String dataNascimento, String registroGeral, String numeroCPF, Pessoa pai, Pessoa mae) {
        super(nome, idade, dataNascimento, registroGeral, numeroCPF, pai, mae);
    }
}
```

- Herda os atributos e métodos
- Na classe específica, usamos no construtor o `super` ao invés do `this` para dizer que estamos chamando o construtor de `Pessoa`
- Para sobscrever os métodos usamos a anotação `@Override`

## Classes abstratas

- Usamos a palavra reservada `abstract` para impedir que ela possa ser instanciada
- Representa um conceito e não uma especificação. Usada com o propósito de reaproveitamento de código por meio da herança
- No exemplo a classe `Pessoa` não pode ser instanciada
- Semelhante a ideia de interfaces porém, podemos utilizar os atributos

```java
public abstract class Pessoa {
    
}
```