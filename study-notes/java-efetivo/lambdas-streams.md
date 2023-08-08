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
