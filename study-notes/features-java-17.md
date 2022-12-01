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

## Pattern Matching para switch

- � um recurso de pr�-visualiza��o. Provavelmente ser� implementado como vers�o final na pr�xima vers�o LTS
- O pattern matching evita a utiliza��o de longos blocos if-else
- � uma declara��o switch com melhor sintaxe e funcionalidade
- Sem o pattern matching

```java
    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY; // Assign here the value
        switch (dayOfWeek) {
            case SUNDAY:
            case SATURDAY:
                System.out.println("Weekend");
                break;
            case FRIDAY:
            case THURSDAY:
            case WEDNESDAY:
            case TUESDAY:
            case MONDAY:
                System.out.println("Weekday");
                break;
            default:
                System.out.println("Unknown Day!");
        }
    }
```

- Com o pattern matching

```java
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.MONDAY; // Assign here the value
        System.out.println(switch (day) {
            case SUNDAY, SATURDAY -> "Weekend";
            case FRIDAY, THURSDAY, WEDNESDAY, TUESDAY, MONDAY -> "Weekday";
        });
    }
```

## Text block

- Facilita a leitura de textos grandes
- Geralmente utilizados em consultas SQL
- Melhora manuten��o futuramente desse tipo de estrutura

```java
    public static void main(String[] args) {
        String query = """
                    SELECT 
                        products.id,
                        products.name,
                        products.category
                    FROM products
                    WHERE products.id = 1
                    ORDER BY products.name;
                """;
        System.out.println(query);
    }
```
