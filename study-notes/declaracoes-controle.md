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
