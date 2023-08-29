# Concorr�ncia

## Item 78: Sincronize o acesso aos dados mut�veis compartilhados

- Embora a especifica��o da linguagem garanta que uma thread n�o ver� um valor arbitr�rio ao ler um campo, n�o garante que um valor escrito por uma thread ser� v�sivel por outra
- A sincroniza��o � necess�ria para a comunica��o confi�vel entre as threads, bem como para a exclus�o mutua. Essa situa��o se deve a uma parte da especifica��o da linguagem conhecida como modelo de mem�ria, que especifica quando e como as altera��es feitas por uma thread se tornam vis�veis para as outras
- As consequ�ncias de n�o sincronizar o acesso aos dados mut�veis compartilhados podem ser terr�veis, mesmo se os dados forem atomicamente leg�veis e grav�veis
- A melhor maneira de evitar os problemas discutidos nesse item � n�o compartilhar dados mut�veis. Compartilhe dados imut�veis ou n�o compartilhe nada
- Confine os dados mut�veis em uma �nica thread

## Item 79: Evite a sincroniza��o excessiva

- Dependendo da situa��o, a sincroniza��o excessva pode provocar a redu��o do desempenho, conflito ou mesmo compartamento n�o determin�stico
- Para evitar falhas de liveness e de seguran�a, nunca ceda o controle ao cliente dentro de um m�todo ou bloco sincronizado
- Trabalhe o m�nimo poss�vel nas regi�es sincronizadas. Ao projetar uma classe mut�vel, pense se ela deve fazer a pr�pria sincroniza��o. Em uma era de m�ltiplos n�cleos, � mais importante do que nunca n�o abusar da sincroniza��o

## Item 80: D� prefer�ncia aos executores, �s tarefas e �s streams em vez das threads

- Voc� pode fazer muito mais coisas com um servi�o executor. Por exemplo, esperar que uma determinada tarefa seja concluida, esperar que alguma ou todas as tarefas de uma cole��o sejam concluidas, esperar a finaliza��o do servi�o executor, recuperar os resultados das tarefas um ap�s outro, � medida que s�o concluidas, pode agendar tarefas pra executarem um hor�rio espec�fico ou periodicamente e assim por diante

## Item 81: Prefira os utilit�rios de concorr�nciaao `wait` e ao `notify`

- Desde o java 5, a plataforma vem disponibilizando utilit�rios de concorr�ncia de alto n�vel, que fazem tipos de coisas que voc� outrora tinha que codificar manualmente em cima do `wait` e do `notify`
- Dada a dificuldade de usar o `wait` e `notify` corretamente, voc� deve usar os utilit�rios de concorr�ncia de n�vel superior
- Por exemplo, use a `ConcurrentHashMap` em vez da `Collections.synchronizedMap`. Substituir maps sincronizados por maps concorrentespode aumentar e muito o desempenho das aplica��es concorrentes

## Item 82: Documente a thread safety

- A presen�a do modificador `synchronized` em uma declara��o de m�todo � um detalhe de implementa��o, n�o parte de sua API
- Para possibilitar o uso concorrente seguro, uma classe deve documentar com clareza o n�vel de thread safety que suporta
- Documentar uma classe condicionalmente thread-safe requer cuidado. Voc� deve indicar quais sequ�ncias de invoca��o exigem sincroniza��o externa e qual bloqueio (ou, em casos raros, bloqueios) deve ser utilizado para executar essas sequ�ncias. Normalmente, � o bloqueio na pr�pria inst�ncia, mas h� exce��es
- Toda classe deve documentar claramente suas propriedades de thread safety com uma descri��o de texto redigida com muito cuidado ou com uma nota��o de thready safety.
- Classes condiciona++lmente thread-safe devem documentar quais sequ�ncias de invoca��o do m�todo exigem uma sincroniza��o externa e quais bloqueios devem ser adquiridos ao executar essas sequ�ncias

## Item 83: Utilize a inicializa��o pregui�osa com parcim�nia

- A inicializa��o pregui�osa � o ato de atrasar a inicializa��o de um campo ate que seu valor seja necess�rio. Se o valor nunca for necess�rio, o campo nunca ser� inicializado
- Essa t�cnica se aplica aos campos est�ticos e aos de inst�ncia. Enquanto a inicializa��o pregui�osa � basicamente uma otimica��o, tamb�m pode ser usada para romper as circularidades prejudiciais na inicializa��o de classes e inst�ncias

## Item 84: N�o dependa do agendador de threads

- Quando muitas threads s�o execut�veis, o agendador de threads determina quais devem ser executadas e por quanto tempo. Qualquer sistema operacional normal tentar� fazer essa determina��o de forma imparcial, mas a pol�tica pode variar
- Programas bem escritos n�o devem depender dos detalhes dessa pol�tica
- N�o dependa do agendador de threads para a corre��o de seu programa. O programa resultante n�o ser� robusto nem port�til.
- As propriedades da thread podem ser usadas com parcim�nia para melhorar a qualidade do servi�o de um programa j� em funcionamento, mas nunca devem ser utilizadas para "corrigir" um programa que mal funciona