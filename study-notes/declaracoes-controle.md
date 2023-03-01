# Declarações de controle

- É um recurso presente nas linguagens de programação
- As instruções de controle do programa Java podem ser definidos nas categorias de seleção, iteração e salto
- As declarações de seleção permitem que o programa escolha diferentes caminhas de de execução com base no resultado de uma expressão
- As instruções de iteração permitem que a execução de um programa repita um ou mais vezes formando loops
- As instruções de salto permitem que o programa execute de forma não linear

## Instruções de seleção

- Java suporta 2 tipos de seleção `if` e `switch`
- Essas instruções permitem que seja realizado o controle da execução do programa baseado em uma condição

### `if`

- Pode ser usado para declarações condicionais

```java
if (expression boolean) {
  return true
} else { 
  return false
}
```

### `else if `

- É útil quando queremos estabelecer mais de 1 condição pré existente caso não seja satisfeito no primeiro `if`
- Uma alternativa mais clean do if aninhado

```java
if (expression boolean) {
  return 
} else if (expression boolean){ 
  return 
} else if (expression boolean) {
  return
} else {
  return
}
```

### Tradicional `switch`

- A instrução `switch` fornece de uma maneira fácil o controle de fluxo de execução com base em um valor de uma expressão
- Fornece uma alternativo, em alguns casos, melhor que uma grande série de instruções `if else if`
- A partir da versão JDK 14 houve algumas melhorias no `switch`
- Forma tradicional do switch

```java
switch (expression) {
  case value1:
  // statement sequence
  break;
  case value2:
  // statement sequence
  break;
  default:
  // statement sequence
 }
```

## Instruções de interação

- As instruções de interação são conhecidas como laços de repetições `for`, `while` e `do-while` que formam estruturas de loops

### `while` 

- São estruturas 'enquanto'. Executa um loop por determinada condição

```java
while (condition) {
  // body of loop
}
```
- A condiçção pode der qualquer expressão booleana
- O corpo do executado do loop é executado quando a condição é true
- Este tipo de estrutura é útil quando não sabemos ao certo quando deve-se parar

### `do-while`

- São estruturas que executam o corpo de instrução antes de realizar a validação. Ao menos é executado 1 vez
- Representa a estrutura 'faça'

```java
do {
  // body of loop
} while (condition);
```

### `for` 

- É um tipo de esturutra de repetição que é possível inserir uma inicialização existentes e muito usado para iteraçoees
- Representa a estrutura 'para'


```java
for ( inicialization; condition; opcional) {
  // body of loop
}
```

### `for-each` 

- Semelhante ao `for`. Uma versão alternativa mais limpa e fácil de entender

```java
for(type itr-var : collection) statement-block
```
