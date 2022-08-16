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

## Métodos abstratos

- São os métodos definidos em uma classe abstrata onde não possui implementação
- A implementação do método deve ser realizada na classe filha
- Reaproveitamento de código e deixar responsabilidades a classes filhas
- Exemplo de um método abstrato

```java
public abstract void metodoAcao() {}
```

## Polimorfismo

- É um dos pilares da orientação a objetos
- Permite a referêcia da classe mãe e comportamentos da classe filha
- Trata vários tipos de maneira homogênea
- Significa muitas formas
- Deixa o código mais coeso e fácil manutenção
- Exemplo de polimorfismo

```java
Pessoa aluno = new Aluno();
```

- Nesse exemplo temos um aluno que é uma pessoa sendo instanciado como Aluno
- Usa os métodos de pessoa mas a implmentação fica para classe Aluno

## Interfaces

- É uma das formas de obrigar a implementação de métodos em classes que a implementam
- Funciona como um contrato para a classe
- Muito utilizado em Api's e frameworks
- As interfaces exige somente assinatura de métodos abstratos
- A diferença entre classes abstratas e interfaces é que as classes possui atributos que podem ser compartilhados entre as classes filhas e a interface exige somente abstração dos métodos
- Exemplo da criação de uma interface

```java
public interface FiguraGeometrica {
 public String getNomeFigura();
 public int getArea();
 public int getPerimetro();
}
```

- Classe que implementa a interface

```java
public class Quadrado implements FiguraGeometrica {

    private int lado;

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public int getArea() {
        int area = 0;
        area = lado * lado;

        return area;
    }

    @Override
    public int getPerimetro() {
        int perimetro = 0;

        perimetro = lado * 4;
        return perimetro;
    }

    @Override
    public String getNomeFigura() {
        return "quadrado";
    }
}
```