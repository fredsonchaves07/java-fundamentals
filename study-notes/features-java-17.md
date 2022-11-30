# Novidades do Java 17

## Records

- Inicialmente foi implementado no java 14
- O record � um tipo de classe especial utilizado para representar dados
- Pode ser um recurso interessante na utiliza��o do padr�o de DTO's
- Implementa os getters do valor automaticamente
- Pode ser utilizado para tornar a classe imut�vel
- Exemplo de utiliza��o de record

```java
public record Product(String name, Integer price) {

    // Construtor com valores opcionais
    public Product(String name) {
        this(name, 10);
    }

    public Product(Integer price) {
        this("", price);
    }
    
    //Construtor com regra espec�ficas
    public Product() {
        name = name() + "!!";
    }
}
```

## Sealed Classes

- Define uma forma de extens�o de uma classe ou interface
- Mais controle sobre quais classes podem estender sua classe
- Pode ser um recurso �til no desenvolvimento de bibliotecas e frameworks

```java
public sealed class Shape permits Rectangle, Circle {

}

sealed class Rectangle extends Shape {}

non-sealed class Circle extends Shape {}

final class Square extends Rectangle{}

```