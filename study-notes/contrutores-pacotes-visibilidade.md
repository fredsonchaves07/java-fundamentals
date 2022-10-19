# Construtores, pacotes e visibilidades

## Construtor

- Responsável por construir e inicializar os valores dos atributos do objeto
- Também é possível construir um objeto com valor vazio (Construtor padrão)
- Exemplo de utilização de construtor com parâmetro

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

- Exemplo de construtor padrão

```java
    public Aluno() {
    
    }
    
    Aluno aluno = new Aluno();
```

### Sobrecarga de construtores

- Também é possível ter mais de um construtor de classe. Mesma ideia dos métodos. Essa estratégia é denorminada de sobrecarga de construtores. Não usamos a anotação `@Override`
- Não é possível ter mais de 1 construtor com a mesma quantidade e mesmo tipos de parâmetros
- Usamos a instrução `this()` quando queremos chamar outro construtor (hieraquia de chamada de construtores)

```java
    public Aluno(String nome, int idade) {
      this(nome);
      this.idade = idade;
    }

    public Aluno(String nome) {
      this.nome = nome;
    }
    
```

## Modificador final em variáveis de instância

- O modificador final é utilizado para definir um valor obrigatório na variável
- O valor pode ser inicializado no construtor ou na classe
- Impossibilita alteração da variável

```java
  final String codigo = "1ac60";
```
