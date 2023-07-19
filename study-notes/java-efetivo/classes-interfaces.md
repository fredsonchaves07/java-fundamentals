# Classes e interfaces

## Item 15: Reduza ao m�nimo a acessibilidade das classes e de seus membros

- O fator mais importante que distingue um componente bem projetado de um com m� qualidade � o grau em que o componente esconde seus dados internos e outros detalhes de implementa��o de outros componentes.
- Um componente bem projetado oculta todos os detalhes de implementa��o, separando cuidadosamente sua API da pr�pria implementa��o.
- Fa�a com que cadaclasse ou membro seja o mais inacess�vel poss�vel
- Se uma classe ou interface pacote-privado de n�vel superior � usada por uma �nica classe, pense na possibilidade de transofmrar essa classe de n�vel superior em uma classe aninhada est�tica privada da �nica classe que a usa. Isso restringe sua acessibilidade apenas � classe que a usa emvez de todas as classes em seu pacote

## Item 16: Use os m�todos getters em classes p�blicas e n�o os campos p�blicos

- Se uma classe � acess�vel fora do seu pacote, forne�a m�todos getters a fim de preservar a flexibilidade para alterar a representa��o interna da classe
- Se uma classe � de pacote privado ou aninhado n�o h� necessidade de utilizar o m�todo getters para expor os campos

## Item 17: Reduza a mutabilidade das classes ao m�nimo

- Uma classe imut�vel � simplesmente uma classe cujas inst�ncias n�o podem ser modificadas. Todas as informa��es contidas em cada inst�ncia s�o fixas durante a vida �til do objeto, portanto, nenhuma altera��o jamais ser� vista.
- As classes imut�veis s�o mais f�ceis de projetas, implementar e de usar do que as mut�veis. Elas est�o sujeitas a poucos erros e s�o mais seguras.
- Para desenvolver uma classe imut�vel, siga esas cinco regras:

1) **N�o forne�a m�todos que modifique o estado do objeto**
2) **Garanta que a classe n�o possa ser estendida**
3) **Fa�a com que todos os campos sejam finais**
4) **Fa�a com que todos os campos sejam privados**
5) **Garanta o acesso exclusivo a quaisquer componentes mut�veis**: Nunca inicialize esse campo em uma refer�ncia de objeto fornecida pelo cliente ou retorne esse campo de um getter. Fa�a copias defensivas em construtores, getters e m�todos `readObject`