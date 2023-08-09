# Lambdas e Streams

## Item 42: Prefira os lambdas �s classes an�nimas

- A partir do java 8 a linguagem possibilita que voc� crie suas inst�ncias usando as express�es lambdas ou lambdas para abreviar
- Os lambdas s�o similares �s fun��es da classes an�nimas, por�m muito mais concisos
- Uma linha � o ideal para um lambda, tr�s linhas s�o o m�ximo aceit�vel. Se voc� violar essa regra, isso pode cuasar s�rios danos � legibilidade de seu programa
- Caso um lambda seja longo ou dif�cil de ler, encontre uma forma de simplific�-lo ou refatore seu programa para descart�-lo

## Item 43: D� prefer�ncia �s refer�ncias para m�todos em vez dos lambdas

- Quanto mais par�metros o m�todo tiver, mais boilerplate voc� consegue eliminar com uma refer�ncia para m�todo. Em alguns lambdas, no entando, os nomes dos par�metros que voc� escolhe fornecem uma documenta��o �til, fazendo com que o lambda seja leg�vel e mais pass�vel de manuten��o do que as refer�encias para m�todos, mesmo que o lambda seja mais longo
- As refer�ncias para m�todos normalmente resultam em c�digos mais curtos e claros. Elas tamb�m lhe oferecem uma sa�da caso os lambdas fiquem muito grandes ou complexos
- Voc� pode extrair o c�digo do lambda dentro de um m�todo novo e substituir o lambda por ume refer�ncia para esse m�todo. Voc� pode dar um bom nome ao m�todo e o documentar da maneira que quiser
- Onde as refer�ncias para m�todos forem mais curtas e claras, use-as. Onde n�o forem, fique com os lambdas

## Item 44: Prefira o uso das interfaces funcionais padr�o

- Se uma interface funcional realiza o trabalho para as suas classes, voc� geralmente a deve usar em vez de uma interface funcional feita sob medida.
- Isso far� com que seja mais f�cil de entender sua API ao reduzir sua superfice conceitual e vai proporcionar vantagens de interoperabilidade consider�veis, uma vez que muitas interfaces funcionais padr�es fornecem m�todos padr�es �teis
- A maioria das interfaces funcionais padr�es existe somente para fornecer suporte para tipos primitivos. N�o ceda � tenta��o de usar as interfaces funcionais b�sicas com os tipos primitivos empacotadso em vez de usar as interfaces funcionais primitivas

## Item 45: Seja criterioso ao utilizar as streams

- A API de streams � vers�til o suficiente para que praticamente qualquer c�lculo seja executado usando streams, mas isso n�o significa que voc� deve execut�-los. Quando utilizadas apropriadamente, as streams deixam os programas mais curtos, claros e limpos; quando usadas de modo inapropriado, fazem com que os programas sejam dif�ceis de ler e de fazer a manuten��o
- Utilizar excessivamente as streams faz com que os programas fiquem dif�ceis de se ler e de fazer manuten��o
- Evite usar streams para processar valores char
- Em suma, algumas tarefas s�o mais bem realizadas com as streams e outras, com intera��o. Muitas outras s�o mais bem realizadas ao combinar as duas abordagem
- N�o existem regras r�pidas e r�gidas para escolher qual abordagem se deve usar para uma tarefa, por�m h� algumas heur�sticas �teis.
- Se voc� n�o tem certeza se uma tarefa � melhor atendida por uma stream ou por uma itera��o, tente usar as duas e veja qual delas funciona melhor

## Item 46: D� prefer�ncia �s fun��es sem efeitos colaterais nas streams

- A stream n�o � apenas uma API, � um paradigma baseado em programa��o funcional. Para conseguir a expressividade, a rapidez e, em alguns casos, a paraleliza��o que as streams oferecem, voc� deve adotar esse paradigma junto com a API
- A parte mais importante do paradigma das streams � estruturar seu c�lculo como uma sequ�ncia de transforma��es em que o resultado de cada est�gio seja o mais pr�ximo poss�vel de uma fun��o pura do resultado do est�gio anterior.
- Uma fun��o pura � aquela cujo resultado depende apenas de sua entrada: n�o depende de nenhum estado mut�vel, nem atualiza nenhum estado.
- A fim de conseguir fazer isso, quaisquer objetos de fun��o que voc� passar para as opera��es de stream, intermedi�rias ou terminais, n�o devem ter efeitos colaterais

## Item 47: D� prefer�ncia � Collection como um tipo de retorno em vez da stream

- A interface `Collection` � um subtipo da `Iterable` e tem um m�todo `stream`, portanto, possibilita tando a itera��o como o acesso em stream. � vista disso, a `Collection` ou um subtipo apropriado � geralmente o melhor tipo de retorno para um m�todo p�blico que retorne uma sequ�ncia
- Em suma, ao escrever um m�todo que retorne uma sequ�ncia de elementos, lembre-se de que alguns de seus usu�rios podem querer os processar como uma stream, enquanto outros podem querer realizar itera��es sobre eles. Tente atender ambos os grupos
- Se for pratic�vel retornar uma cole��o, retorne. Se voc� j� tiver os elementos em uma cole��o ou caso o n�mero de elementos em uma sequ�ncia seja pequeno o bastante para justificar a cria��o de uma nova, retorne uma cole��o padr�o, como um `ArrayList`. Caso contr�rio, pense em implementar uma customizada
- Na hip�tese de, em uma vers�o futura do Java, a declara��o da interface `Stream` ser modificada para estender a `Iterable`, sinta-se � vontade para retornar streams, pois elas permitir�o tanto o processamento de stream quanto a itera��o

## Item 48: Tenha cuidado ao fazer streams paralelas

- N�o paralelize as streams pipelines indiscriminadamente. As consequ�ncias para o desempenho podem ser desastrosas
- Via de regra, os ganhos de desempenho com paralelismo s�o melhores nas stream sobre inst�ncias `ArrayList`, `HashMap`, `HashSet` e `ConcurrentHashMap`; arrays, ranges `int` e ranges `long`
- O que essas estruturas de dados tem em comum � que podem ser divididas com precis�o e em subranges de qualquer tamanho que voc� quiser, o que facilita a divis�o de trabalho entre as threads paralelas