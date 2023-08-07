# Enums e anota��es

## Item 34: Use enums em vez de constantes `int`

- Os programas que usam os enums int s�o inst�veis. Como os enums int s�o vari�veis constantes, seus valores int s�o compilados dentro dos clientes que os usam. Se o valor associado a um enum int for modificado, seus clientes devem ser recompilados. Caso contr�rio, os clientes ainda ser�o executados, por�m se comportar�o deforma errada
- Voc� pode encontrar uma variante desse padr�o no qual constantes string s�o utilizadas no lugar das constantes int. Essa variante, conhecida como padr�o enum string, � ainda menos aconselh�vel
- O java fornece uma alterantiva que evita todas as limita��es dos padr�es enum int e enum string, e oferece muitas vantagens adicionais
- Um tipo enum pode dar seus primeiros passos como uma simples cole��o de constantes enum e, ao longo do tempo, evoluir e tornase uma abstra��o completa
- Alguns comportamentos relacionados �s constantes enums podem precisar ser usados apenas dentro da classe ou pacote em que o enum foi definido. Esses comportamentos s�o mais bem implementados como m�todos privados pacotes privados
- Os enums s�o, em geral, compar�veis com o desempenho das costantes int. Uma pequena desvantagem em rela��o ao desempenho dos enums � que voc� tem que arcar com o custo de espa�o e tempo para carregar e inicializar os tipos enum, mais isso � pouco not�vel na pr�tica
- Use os enums sempre que precisar de um conjunto de constantes cujo membros s�o conhecidos em tempo de compila��o

## Item 35: Use oscampos de inst�ncia em vez dos valores ordinais

- Nunca calcule um valor associado a um enum de seu ordinal; em vez disso, armazene-o em um campo de inst�ncia
- A especifica��o do `Enum` fala o seguinte a respeito do ordinal: "A maiorira dos programadores n�o usar� este m�todo. Ele foi projetado para o uso por estruturas de dados de uso geral baseadas em enums, tais como a `EnumSet`e a `EnumMap`". A menos que esteja escrevendo c�digo dessa natureza, � melhor voc� evitar completamente o m�todo ordinal

## Item 36: Use a classe `EnumSet` em vez dos campos de bits

- Alguns programadores que utilizam os enums em vez das constantes int ainda se apegam ao uso dos campos de bits sempre que precisam passar sets de constantes. N�o h� raz�o para se fazer isso, pois existe uma alternativa melhor. O pacote `java.util` fornece uma classe `EnumSet` que representa de modo eficiente conjunto de valores retirados de um �nico tipo enum
- Essa classe implementa a interface `Set`, disponibilizando toda a abud�ncia, type safety, e interoperabilidade que voc� consegue com qualquer outra implementa��o `Set`
- A classe `Set` combina a concis�o e o desempenho dos campos de bits com as in�meras vantagens dos tipos enum

## Item 37: Use `EnumMap` em vez da indexa��o ordinal

- Raramente � adequado utilizar os ordinais para indexar os arrays: Em vez disso, use a `EnumMap`

## Item 38: Emule enums extens�veis por meio de interfaces

- Na maioria das vezes, a extensibilidade de enums acaba sendo uma p�ssima ideia. � um tanto confuso que os elementos de um tipo estendido sejam inst�ncias do tipo base e n�o vice-versa
- Existe pelo menos uma situa��o em que vale a pena utilizar os tipos enumerados extens�veis, nos c�digo de opera��o, tamb�m conhecidos como opcodes. Um opcode � um tipo enumerado cujos elementos representam opera��es em alguma m�quina, como o tipo `Operation`
- Existe uma forma simp�tica de se fazer isso utilizando os tipos enums. Trata-se de aproveitar o fato de que os tipos enum implementam interfaces
- Embora voc� n�o possa escrever um tipo enum extens�vel, consegue emul�-lo ao escrever uma interface para acompanhar um tipo enum base que, por sua vez, implementa a interface

## Item 39: Prefira as anota��es aos padr�es de nomenclatura

- Se escrever uma ferramenta que exiga que os programadores adicionem informa��es ao c�digo fonte, defina tipos de anota��es apropriados. Simplesmente n�o h� nenhuma raz�o para voc� usar padr�es de nomeclatura quando pode utilizar as anota��es
- Os programadores devem usar is tipos de anota��es predefinidos que o java fornece

## Item 40: Use a anota��o `Override` com frequ�ncia

- Essa anota��o s� pode ser usad nas declara��es de m�todo, e indica que a declara��o de m�todo anotada sobrescreve a declara��o em um supertipo. Se utilizar constantemente essa anota��o, ela o proteger� de uma grande classe de bugs nefastos
- H� apensas uma pequena exce��o a essa regra. Se estiver escrevendo uma classe que n�o esteja rotulada como abstrata e estiver convencido de que ela sobrescreve um m�todo abstrato de sua superclasse, n�o se preocupe em colocar a anota��o no m�todo.

## Item 41: Use as interfaces marcadoras para definir tipos

- Uma interface marcadora n�o cont�m declara��es de m�todos, por�m designa uma classe que implementa a interface como tendo alguma propriedade
- As interfaces marcadoras definem um tipo que � implementado pelas instancias da classe marcada; j� as anota��es marcadoras, n�o
- Se voc� n�o quer definir um tipo, n�o use uma interface. Se voc� quer de fato definir um tipo, use uma interface