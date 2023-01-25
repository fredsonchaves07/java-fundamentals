# Tipos de dados, variaveis e arrays

## Linguagem fortemente tipada

- Uma das características do Java
- Faz parte da segurança e robustez do Java
- Toda variável tem um tipo e todo tipo é estritamente definido
- O compilador Java verifica todas as expressões e parâmetros para garantir que os tipos sejam compativeis

## Tipos primitivos

- Java define 8 tipos primitivos bases: **byte, short, int, long, char, float, double e boolean** 
- Eles formam uma base para todos os outros tipos
- Embora Java seja uma linguagem fortemente orientada objetos, os tipos primitivos não são
- Isso pode está relacionado a eficiência e desempenho
- Os tipos primitivos 

## Inteiros

- Java define quatro tipos de inteiros **byte, short, int e long** 
- Todos eles são assinados valores positivos e negativos
- O Range e o tamanho dos tipos de inteiros podem ser consultados na tabela abaixo
 ![Captura de tela de 2023-01-25 11-40-12](https://user-images.githubusercontent.com/43495376/214592561-2962bec8-9019-4ada-8be2-c1e1a759a819.png)

### `byte`

- O menor tipo inteiro
- Tem um tamando de 8 bits e possui um intervalo de -128 a 127
- Este tipo de inteiro é usado principalmente para trabalhar com stream de dados de internet ou arquivo
- Também pode ser utilizado para ser trabalhado com dados binários

```java
byte bm c;
```

### `short`

- É o tipo inteiro de 16 bits. Possui um intervalo de -32,768 a 32,767
- É o menos tipos de dados usados

```java
short s;
```

### `int`

- É o tipo mais comum utilizado
- Possui um tamanho de 32 bits e aceita um intervalo de -2,147,486,648 a 2,147,483,647
- Muito utilizado em loops e indexes de arrays
- É a melhor opção quando um número inteiro é necessário

### `long`

- É um tipo de 64 bits usado quando o tipo `int` não é suficiente
- Exemplo de utilização de long. Um programa que calcula o número de milhas que a luz pecorrerá em determinado número de dias

```java
class Light {
  public static void main(String[] args) {
    int lightspeed;
    long days;
    long seconds;
    long distance;
    // approximate speed of light in miles per second
    lightspeed = 186000;
    days = 1000; // specify number of days here
    seconds = days * 24 * 60 * 60; // convert to seconds
    distance = lightspeed * seconds; // compute distance
    System.out.print("In " + days);
    System.out.print(" days light will travel about ");
    System.out.println(distance + " miles.");
  }
}
```

O programa gerá o seguinte resultado

```shell
In 1000 days light will travel about 16070400000000 miles.
```

## Tipos flutuantes

- Conhecido como números reais, usado para avaliar expressões que requeiram uma precisão
- Utilizado para realizar calculo de funções matemáticas
- Java implementa o conjunto padrão (IEE-754) de tipos flutuantes e operadores
- Existem dois tipos de tipos flutuante `float` e `double`

![Captura de tela de 2023-01-25 11-54-06](https://user-images.githubusercontent.com/43495376/214596022-5e629a2c-74e7-4a1c-b599-d5c780eb5cd9.png)

### `float`

- Especifica o uma precisão simples e usa 32 bits.
- Este tipo de ponto flutuante é rapido para alguns processadores e ocupa menos espaço, mas pode se tornar impreciso quando tem valores altos ou pequeno

```java
float higtemp;
```

#### `double`

- Especifica o tipo de precisão dupla de 64 bits
- Util quando queremos ter mais precisão de um valor
- Pode ser mais rápida em alguns processadores modernos que é otimizado para realizar calculos matemáticos como `sin()`, `cos()` e `sqrt()` 
