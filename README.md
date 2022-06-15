# Fundamentos de programação Java

Repositório que contém as notas de estudo e código desenvolvido durante os cursos

## Tecnologias utilizadas
- [x] Java 17

## Indice
- 
## Introdução ao Java
### Plataforma e linguagem Java
- Quanto plataforma, o Java disponibiliza todos os recursos, ferramentas e programas que facilita o desenvolvimento
- Enquanto linguagem, o Java é uma linguagem de programação com foco em orientação a objetos
- A plataforma e a linguagem andam juntos (caixa de ferramenta)

### Caracterísitcas do Java
- [x] Suporte à orientação a objetos
- [x] Portabilidade
- [x] Segurança
- [x] Linguagem simples
- [x] Alta perfomance
- [x] Dinamismo
- [x] Interpretada
- [x] Distribuído
- [x] Independente de plataforma
- [x] Tipada

### Java Virtual Machine (JVM)
- Software que simula uma máquina física e consegue executar vários programas, gerenciar processos, memória e arquivos
- Plataforma onde a memória, o processador e os seus outros recursos são totalmente virtuais, não dependendo de hardwares

### Java Runtime Environment (JRE)
- Ambiente que executa aplicações da plataforma Java
- Composto por bibliotecas e pela máquina virtual (JVM)

### Java Development Kit (JDK)
- Conjunto de utilitários que permitem a criação de sistemas para a plataforma Java
- Composto por compilador e biblioteca

## Introdução à Orientação a Objetos
- É um modelo de análise, projeto e programação de software baseado na composição e interação entre diversas unidades chamadas de 'objetos'
- Consiste em principios como abstração e representação do mundo real para o computacional

### Classe e Objeto
- Uma classe é uma forma de definir um tipo de dados (Escopo)
- Abstração de como será definido um conceito (Forma)
- Formada por dados e comportamentos (Atributos, características e ações)
- O objeto é a representação computacional da classe, do escopo o que foi definido
- A classe é algo mais genérico enquanto que o objeto é específico
- O principal objetivo de um objeto é carregar as informações agrupadas, processar, gravar e exibir
![Captura de tela de 2022-06-15 09-55-38](https://user-images.githubusercontent.com/43495376/173832234-a3f7f8a7-8d05-4b83-b196-37b74cb2adfe.png)
- Exemplo de utilização de classe
```java
 public class Aluno {

    String aluno;

    int idade;

    String dataNascimento;

    String registroGeral;

    String numeroCPF;

    String nomeMae;
}
``` 

### Construtores
- Inicializa os valores dos atributos do objeto
- Responsável pela construção do objeto
- Realiza a construção de um objeto vazio (sem valores). Exemplo utilizando um construtor padrão
```java
    public Aluno() {
    
    }
    
    Aluno aluno = new Aluno();
```
- O construtor inicializa os valores dos atributos com base nos parâmetros
```java
    public Aluno(String nome, int idade, String dataNascimento, String registroGeral, String numeroCPF) {
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.registroGeral = registroGeral;
        this.numeroCPF = numeroCPF;
    }

    Aluno alunoMaria = new Aluno("Maria", 22, "10/01/2002", "0210214", "0145503");
```
- A palavra `this` chama o atributo (O que diferencia a variavel da classe com o parâmetro do construtor)