# Enums e anotações

## Item 34: Use enums em vez de constantes `int`

- Os programas que usam os enums int são instáveis. Como os enums int são variáveis constantes, seus valores int são compilados dentro dos clientes que os usam. Se o valor associado a um enum int for modificado, seus clientes devem ser recompilados. Caso contrário, os clientes ainda serão executados, porém se comportarão deforma errada
- Você pode encontrar uma variante desse padrão no qual constantes string são utilizadas no lugar das constantes int. Essa variante, conhecida como padrão enum string, é ainda menos aconselhável
- O java fornece uma alterantiva que evita todas as limitações dos padrões enum int e enum string, e oferece muitas vantagens adicionais
- Um tipo enum pode dar seus primeiros passos como uma simples coleção de constantes enum e, ao longo do tempo, evoluir e tornase uma abstração completa
- Alguns comportamentos relacionados às constantes enums podem precisar ser usados apenas dentro da classe ou pacote em que o enum foi definido. Esses comportamentos são mais bem implementados como métodos privados pacotes privados
- Os enums são, em geral, comparáveis com o desempenho das costantes int. Uma pequena desvantagem em relação ao desempenho dos enums é que você tem que arcar com o custo de espaço e tempo para carregar e inicializar os tipos enum, mais isso é pouco notável na prática
- Use os enums sempre que precisar de um conjunto de constantes cujo membros são conhecidos em tempo de compilação

## Item 35: Use oscampos de instância em vez dos valores ordinais

- Nunca calcule um valor associado a um enum de seu ordinal; em vez disso, armazene-o em um campo de instância
- A especificação do `Enum` fala o seguinte a respeito do ordinal: "A maiorira dos programadores não usará este método. Ele foi projetado para o uso por estruturas de dados de uso geral baseadas em enums, tais como a `EnumSet`e a `EnumMap`". A menos que esteja escrevendo código dessa natureza, é melhor você evitar completamente o método ordinal

## Item 36: Use a classe `EnumSet` em vez dos campos de bits

- Alguns programadores que utilizam os enums em vez das constantes int ainda se apegam ao uso dos campos de bits sempre que precisam passar sets de constantes. Não há razão para se fazer isso, pois existe uma alternativa melhor. O pacote `java.util` fornece uma classe `EnumSet` que representa de modo eficiente conjunto de valores retirados de um único tipo enum
- Essa classe implementa a interface `Set`, disponibilizando toda a abudância, type safety, e interoperabilidade que você consegue com qualquer outra implementação `Set`
- A classe `Set` combina a concisão e o desempenho dos campos de bits com as inúmeras vantagens dos tipos enum

## Item 37: Use `EnumMap` em vez da indexação ordinal

- Raramente é adequado utilizar os ordinais para indexar os arrays: Em vez disso, use a `EnumMap`

## Item 38: Emule enums extensíveis por meio de interfaces

- Na maioria das vezes, a extensibilidade de enums acaba sendo uma péssima ideia. É um tanto confuso que os elementos de um tipo estendido sejam instâncias do tipo base e não vice-versa
- Existe pelo menos uma situação em que vale a pena utilizar os tipos enumerados extensíveis, nos código de operação, também conhecidos como opcodes. Um opcode é um tipo enumerado cujos elementos representam operações em alguma máquina, como o tipo `Operation`
- Existe uma forma simpática de se fazer isso utilizando os tipos enums. Trata-se de aproveitar o fato de que os tipos enum implementam interfaces
- Embora você não possa escrever um tipo enum extensível, consegue emulá-lo ao escrever uma interface para acompanhar um tipo enum base que, por sua vez, implementa a interface

## Item 39: Prefira as anotações aos padrões de nomenclatura

- Se escrever uma ferramenta que exiga que os programadores adicionem informações ao código fonte, defina tipos de anotações apropriados. Simplesmente não há nenhuma razão para você usar padrões de nomeclatura quando pode utilizar as anotações
- Os programadores devem usar is tipos de anotações predefinidos que o java fornece

## Item 40: Use a anotação `Override` com frequência

- Essa anotação só pode ser usad nas declarações de método, e indica que a declaração de método anotada sobrescreve a declaração em um supertipo. Se utilizar constantemente essa anotação, ela o protegerá de uma grande classe de bugs nefastos
- Há apensas uma pequena exceção a essa regra. Se estiver escrevendo uma classe que não esteja rotulada como abstrata e estiver convencido de que ela sobrescreve um método abstrato de sua superclasse, não se preocupe em colocar a anotação no método.

## Item 41: Use as interfaces marcadoras para definir tipos

- Uma interface marcadora não contém declarações de métodos, porém designa uma classe que implementa a interface como tendo alguma propriedade
- As interfaces marcadoras definem um tipo que é implementado pelas instancias da classe marcada; já as anotações marcadoras, não
- Se você não quer definir um tipo, não use uma interface. Se você quer de fato definir um tipo, use uma interface