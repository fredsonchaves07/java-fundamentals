# Serializa��o

## Item 85: Prefira alternativas � serializa��o Java

- A desserializa��o do Java � um perigo evidente e presente, pois � amplamente utilizada diretamente por aplica��es e indiretamente por subsistemas Java, como o RMI, JMX e o JMS
- A desserializa��o de streams n�o confi�veis ocasiona a execu��o remota do c�digo (RCE), a nega��o de servi�o (DoS) e uma s�rie de outros exploits. As aplica��es s�o vulner�veis a esses ataques mesmo que n�o tenham feito nada de errado
- A melhor maneira de se evitarem os exploits de serializa��o � nunca realizar a desserializa��o em nada
- N�o h� motivos para usar a serializa��o Java em qualquer sistema novo que voc� escreva. H� outros mecanismos para tradu��o entre objetos e sequ�ncias de bytes que evitam muitos dos perigos de serializa��o Java, oferecendo in�meras vantagens, como suporte a v�rias plataformas, alto desempenho, um ecossistema enorme de ferramentas e uma comunidade vasta de especialistas
- As principais representa��es de dados estruturados entre plataformas s�o o Json e o Protocol Buffers, tamb�m conhecido como protobuf
- Infelizmente, a serializa��o ainda domina o ecosistema Java. Se voc� est� fazendo manuten��o de um sistema baseado em serializa��o Java, considere seriamente a migra��o para uma representa��o de dados estruturas entre plataformas, mesmo que isso exiga um grande esfor�o

## Item 86: Tenha cautela ao implementar a `Serializable`

- O maior custo da implementa��o da `Serializable` � que ela diminui a flexibilidade de alterar a implementa��o de uma classe uma vez que seja liberada
- O segundo custo de implementa��o da `Serializable` � que ela aumenta a probabilidade de bugs e brechas de seguran�a. Normalmente, os objetos s�o criados com os construtores; a serializa��o � um mecanismo extra lingu�stico para criar objetos. Mesmo se voc� aceeitar o comportamento padr�o ou o sobrescrever, a desserializa��o � um construtor oculto com todos os mesmos problemas que outros construtores
- O terceiro custo da implementa��o da `Serializable` � que ela potencializa a carga de testes associada � libera��o da vers�o nova de uma classe

## Item 87: Pense na possibilidade de usar uma forma serializada customizada

- N�o aceite a forma serializada padr�o sem, primeiro, considerar se � apropriada ou n�o. Aceitar a forma serializa padr�o deve ser uma decis�o consciente de que essa codifica��o � aceit�vel do ponto de vista da flexibilidade, do desempenho e da corre��o.
- Seja qual for a forma serializada que escolher, declare um serial version UID explicito em cada classe serializ�vel que voc� escreva
- Se voc� decidiu que uma classe deve ser serializavel, pense muito a respeito de como a forma serializada deve ser. Use a forma padr�o serializada somente se ela for uma descri��o aceit�vel do estado l�gico do objeto; caso contr�rio, projete uma forma serializada customizada que descreva adequadamente o objeto

## Item 88: Escreva m�todos `readObject` defensivamente

- O `readObject` � um construtor que recebe uma stream de bytes como �nico par�metro. No uso normal, a stream de bytes � gerado serializando uma inst�ncia normalmente constru�da. O Problema surge quando o um objeto que viole as invariantes de sua classe
- Essa stream de bytes pode ser usada para criar um objeto imposs�vel, que n�o poderia ser criado usando um construtor normal
- Quando um objeto � desserializado, � de suma import�ncia copiar defensivamente qualquer campo que tenha uma refer�ncia de objeto que um cliente n�o deve ter

## Item 89: D� prefer�ncia aos tipos enum em vez do `readResolve` para controle de inst�ncia

- Se voc� depender do `readResolve` para o controle de inst�ncia, todos os campos de inst�ncia com tipos de refer�ncia de objeto tem que ser declarados com `transient`
- O uso do `readResolve` para o controle de inst�ncia n�o � obsoleto. Se tiver que escrever uma classe serializ�vel controlodada por inst�ncia, cujas inst�ncias n�o sejam conhecidas em tempo de compila��o, voc� n�o poder� representar a classe com um tipo enum

## Item 90: Pense em usar proxies de serializa��o em vez de inst�ncias serializadas

- Existe uma t�cnica que reduz o risco de implementar a `Serializable` conhecida como o padr�o de proxy de serializa��o
- O padr�o de proxy de serialzia��o � razoavelmente simples. Primeiro, projete uma classe aninhada est�tica privada que represente de forma concisa o estado l�gico de uma inst�ncia de classe envolvente. Essa classe aninhada � conhecida como proxy de serializa��o da classe envolvente
- Ela deve ter um �nico construtor, cujo tipo de par�metro � a classe envolvente. Esse construtor apenas copia os dados do seu argumento
- Tal como a abordagem da c�pia defensiva, esta abordagem impede o ataque fict�cio da stream de bytes e o ataque de roubo de campo interno