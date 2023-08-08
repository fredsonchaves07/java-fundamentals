# Lambdas e Streams

## Item 42: Prefira os lambdas às classes anônimas

- A partir do java 8 a linguagem possibilita que você crie suas instâncias usando as expressões lambdas ou lambdas para abreviar
- Os lambdas são similares às funções da classes anônimas, porém muito mais concisos
- Uma linha é o ideal para um lambda, três linhas são o máximo aceitável. Se você violar essa regra, isso pode cuasar sérios danos à legibilidade de seu programa
- Caso um lambda seja longo ou difícil de ler, encontre uma forma de simplificá-lo ou refatore seu programa para descartá-lo

## Item 43: Dê preferência às referências para métodos em vez dos lambdas

- Quanto mais parâmetros o método tiver, mais boilerplate você consegue eliminar com uma referência para método. Em alguns lambdas, no entando, os nomes dos parâmetros que você escolhe fornecem uma documentação útil, fazendo com que o lambda seja legível e mais passível de manutenção do que as referÇencias para métodos, mesmo que o lambda seja mais longo
- As referências para métodos normalmente resultam em códigos mais curtos e claros. Elas também lhe oferecem uma saída caso os lambdas fiquem muito grandes ou complexos
- Você pode extrair o código do lambda dentro de um método novo e substituir o lambda por ume referência para esse método. Você pode dar um bom nome ao método e o documentar da maneira que quiser
- Onde as referências para métodos forem mais curtas e claras, use-as. Onde não forem, fique com os lambdas

## Item 44: Prefira o uso das interfaces funcionais padrão

- Se uma interface funcional realiza o trabalho para as suas classes, você geralmente a deve usar em vez de uma interface funcional feita sob medida.
- Isso fará com que seja mais fácil de entender sua API ao reduzir sua superfice conceitual e vai proporcionar vantagens de interoperabilidade consideráveis, uma vez que muitas interfaces funcionais padrões fornecem métodos padrões úteis
- A maioria das interfaces funcionais padrões existe somente para fornecer suporte para tipos primitivos. Não ceda à tentação de usar as interfaces funcionais básicas com os tipos primitivos empacotadso em vez de usar as interfaces funcionais primitivas

## Item 45: Seja criterioso ao utilizar as streams

- A API de streams é versátil o suficiente para que praticamente qualquer cálculo seja executado usando streams, mas isso não significa que você deve executá-los. Quando utilizadas apropriadamente, as streams deixam os programas mais curtos, claros e limpos; quando usadas de modo inapropriado, fazem com que os programas sejam difíceis de ler e de fazer a manutenção
- Utilizar excessivamente as streams faz com que os programas fiquem difíceis de se ler e de fazer manutenção
- Evite usar streams para processar valores char
- Em suma, algumas tarefas são mais bem realizadas com as streams e outras, com interação. Muitas outras são mais bem realizadas ao combinar as duas abordagem
- Não existem regras rápidas e rígidas para escolher qual abordagem se deve usar para uma tarefa, porém há algumas heurísticas úteis.
- Se você não tem certeza se uma tarefa é melhor atendida por uma stream ou por uma iteração, tente usar as duas e veja qual delas funciona melhor

## Item 46: Dê preferência às funções sem efeitos colaterais nas streams

- A stream não é apenas uma API, é um paradigma baseado em programação funcional. Para conseguir a expressividade, a rapidez e, em alguns casos, a paralelização que as streams oferecem, você deve adotar esse paradigma junto com a API
- A parte mais importante do paradigma das streams é estruturar seu cálculo como uma sequência de transformações em que o resultado de cada estágio seja o mais próximo possível de uma função pura do resultado do estágio anterior.
- Uma função pura é aquela cujo resultado depende apenas de sua entrada: não depende de nenhum estado mutável, nem atualiza nenhum estado.
- A fim de conseguir fazer isso, quaisquer objetos de função que você passar para as operações de stream, intermediárias ou terminais, não devem ter efeitos colaterais

## Item 47: Dê preferência à Collection como um tipo de retorno em vez da stream

- A interface `Collection` é um subtipo da `Iterable` e tem um método `stream`, portanto, possibilita tando a iteração como o acesso em stream. À vista disso, a `Collection` ou um subtipo apropriado é geralmente o melhor tipo de retorno para um método público que retorne uma sequência
- Em suma, ao escrever um método que retorne uma sequência de elementos, lembre-se de que alguns de seus usuários podem querer os processar como uma stream, enquanto outros podem querer realizar iterações sobre eles. Tente atender ambos os grupos
- Se for praticável retornar uma coleção, retorne. Se você já tiver os elementos em uma coleção ou caso o número de elementos em uma sequência seja pequeno o bastante para justificar a criação de uma nova, retorne uma coleção padrão, como um `ArrayList`. Caso contrário, pense em implementar uma customizada
- Na hipótese de, em uma versão futura do Java, a declaração da interface `Stream` ser modificada para estender a `Iterable`, sinta-se à vontade para retornar streams, pois elas permitirão tanto o processamento de stream quanto a iteração

## Item 48: Tenha cuidado ao fazer streams paralelas

- Não paralelize as streams pipelines indiscriminadamente. As consequências para o desempenho podem ser desastrosas
- Via de regra, os ganhos de desempenho com paralelismo são melhores nas stream sobre instâncias `ArrayList`, `HashMap`, `HashSet` e `ConcurrentHashMap`; arrays, ranges `int` e ranges `long`
- O que essas estruturas de dados tem em comum é que podem ser divididas com precisão e em subranges de qualquer tamanho que você quiser, o que facilita a divisão de trabalho entre as threads paralelas