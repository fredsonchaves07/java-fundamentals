# Novidades do Java 17

## Records

- Inicialmente foi implementado no java 14
- O record é um tipo de classe especial utilizado para representar dados
- Pode ser um recurso interessante na utilização do padrão de DTO's
- Implementa os getters do valor automaticamente
- Pode ser utilizado para tornar a classe imutável
- Exemplo de utilização de record

```java
public record Product(String name, Integer price) {

    // Construtor com valores opcionais
    public Product(String name) {
        this(name, 10);
    }

    public Product(Integer price) {
        this("", price);
    }
    
    //Construtor com regra específicas
    public Product() {
        name = name() + "!!";
    }
}
```

## Sealed Classes

- Define uma forma de extensão de uma classe ou interface
- Mais controle sobre quais classes podem estender sua classe
- Pode ser um recurso útil no desenvolvimento de bibliotecas e frameworks

```java
public sealed class Shape permits Rectangle, Circle {

}

sealed class Rectangle extends Shape {}

non-sealed class Circle extends Shape {}

final class Square extends Rectangle{}

```