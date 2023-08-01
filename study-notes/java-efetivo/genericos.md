# Genericos

## Item 26: N�o use tipos brutos

- Permite-use a utiliza��o de tipos brutos, por�m voc� nunca deve usar. Se voc� usar os tipos brutos, abrir� m�o de todas as vantagens de seguran�a e expressividade oferecidasd pelos gen�ricos
- Perdemos a type safety caso usamos o tipo bruto com `List`, mas n�o se usar um tipo parametrizado com o `List<Object`
- Caso n�o saiba ou se importe com o formato do par�metro real, podemos utizar os wildcards
- Em s�ntese, o uso dos tipos brutos provoca exce��es em tempo de execu��o, portanto, n�o os utilize. Eles s�o disponibilizados exclusivamente para a compatibilidade e a interoperabilidade com c�digos legados anteriores � introdu��o dos gen�ricos na plataforma Java.

## Item 27: Elimine as advert�ncias n�o verificadas

- Ao programar com gen�ricos, voc� ver� que o compilador gera muitas advert�ncias: de cast n�o verificado, de invoca��o de m�todos n�o verificados, de tipo vararg parametrizado n�o verificado e de convers�es n�o verificadas
- Elimine todas as advert�ncias n�o verificadas que conseguir. Ao eliminar todas elas, voc� garante que sej c�digo seja typesafe, o que � uma coisa muito boa
- Caso n�o consiga eliminar uma advert�ncia, mas consiga comprovar que o c�digo que a provocou � typesafe, ent�o (somente nesse caso) suprima a advert�ncia com uma anota��o `@SuppressWarnings("unchecked")`
- Toda vez que voc� usar a anota��o `@SupressWarnings("unchecked")` adicione um coment�rio dizendo porque � seguro utiliza-la

## Item 28: Prefira as listas aos arrays

- Os arrays distinguem-se dos tipos gen�ricos de duas formas importantes. Em primeiro lugar, os arrays s�o convariantes. Os gen�ricos s�o invariantes
- Os arrays proporcionam type safety em tempo de execu��o, mas na hora de compila��o, e o contr�rio se aplica aos gen�ricos.
- Via de regra, os arrays e os gen�ricos n�o se combina bem. � interessante por conta disso, substituir os arrays por listas

## Item 29: Priorize os tipos gen�ricos

- Os tipos gen�ricos s�o mais seguros e f�ceis de se utilizar do que os que exigem a realiza��o de casts no c�digo cliente. Ao projetar tipos novos, provicencie que possam ser usados sem esses casts
- Muitas vezes, isso significar� transform-alos em tipos gen�ricos. Caso tenha quaisquer tipos existentes que deveriam ser gen�ricos, mas n�o o sejam, generifique-os

## Item 30: Priorize os m�todos gen�ricos

- Os m�todos gen�ricos, como os tipos gen�ricos, s�o mais seguros e f�ceis de usar do que os m�todos que exigem de seus clientes a nser��o de casts explicitos nos par�metros de entrada e nos valores de retorno
- Certifique-se de que seus m�todos possam ser utilizados sem casts, o que, muitas vezes, significa transform�-los em gen�ricos

## Item 31: Use os wildcards limitados para aumentar a flexibilidade da API

- Para maximizar a flexibilidade, use os tipos wildcards nos par�metros de entrada que representam os produtores e os consumidores
- Quando usados apropriadamente, os tipos wildcard s�o quase invis�veis para os usuarios de uma classe. Eles fazem os m�todos aceitarem par�metros que deveriam aceitar e rejeitarem aqueles que deveriam rejeitar. Caso o usu�rio de uma classe tenha que pensar sobre tipos wildcard, provavelmente h� algo de errado com a API dela
- Se voc� escrever uma biblioteca que ser� muito utilizada, o uso adequado dos tipos wildcards deve ser considerado imprescind�vel

## Item 32: Seja criterioso ao combinar os gen�ricos com varargs

- A finalidade dos varargs � possibilitar que os clientes passem um n�mero vari�vel de argumentos para um m�todo; todavia, isso � um vazamento de abstra��o: ao invocar os m�todos vargars, cria-se um array para que os par�metros varargs sejam mantidos
- Voc� recebe uma s�rie de advert�ncias confusasdo compilador quando os par�metros varargs tem tipos parametrizados ou gen�ricos
- Use `@SafeVarargs` em cada m�todo com um par�metro varargs de um tipo parametrizado ou gen�rico, de modo que seus usu�rios n�o sejam sobrecarregados por advert�ncias confusas e desencess�rias do compilador
- Toda vez que o compilador lhe advertir de uma poss�vel polui��o do heap advinda de um par�metro vargs gen�rico em um m�todo que voc� controla, verifique se � seguro
- Em suma, varargs e gen�ricos n�o interagem bem em virtude de os recursos dos varargs serem vazamento de abstra��o constu�do sobre os arrays, e de os arrays terem regras de tipagem diferentes dos gen�ricos
- Garanta que o m�todo seja typesafe, e depois anote-o com `@SafeVarargs`

## Item 32: Pense na possibilidade de usar cont�iners heterog�neos typesafe

- As vezes voc� precisa de mais flexibilidade. Por exemplo, uma linha de banco de dados pode arbitrariamente apresentar muitas colunas, e seria bom conseguir acessar todas elas de um modo ypesafe. Por sorte, existe uma maneira f�cil de se realizar essa tarefa.
- Trata-se de parametrizar a chave em vez do cont�iner. Em seguida, apresentar a chave parametrizada ao cont�iner para inserir ou recuprar um valor. O sistema de tipos gen�ricos � utilizada para garantir que o tipo de valor esteja de acordo com sua chave
- Voc� pode utilizar objetos `Class` como chaves para tais cont�ineres heterog�neos typesafe. Um objeto `Class`, quando usado desse modo, chama-se token de tipo
- Voc� tamb�m pode utilizar um tipo de chave customizado. Por exemplo, voc� pode ter um tipo `DatabaseRow` representando uma linha de banco de dados (o cont�iner), e um tipo gen�rico `Column<T>` como sua chave

