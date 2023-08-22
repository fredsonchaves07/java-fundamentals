# Exce��es

## Item 69: Utilize as exce��es somente em circust�ncias excepcionais

- As exce��es s�o, como o nome sugere, para ser usadas apenas em circust�ncias excepcionais; nunca se deve us�-las para o controle de fluxo normal

## Item 70: Utilize as exce��es verificadas para condi��es recuper�veis e exce��es de runtime para erros de programa��o

- Utilize as exce��es verificadas para as condi��es das quais o chamador possa razoavelmente se recuperar. Ao lan�ar uma exce��o verificada, voc� for�a o chamador a lidar com a cl�usula `catch` ou a propagar para o exterior
- Utilize as exce��es de runtime para indicar erros de programa��o
- Todas as throwables n�o verificadas que voc� implementardevem ser subclasses da `RuntimeException`

## Item 71: Evite o uso desnecess�rio das exce��es verificadas

- Quando usadas com modera��o, as exce��es verificadas aumenta a confiabilidade dos programas; quando usadas em excesso, fazem com que as APIs sejam dificeis de se utilizar
- Se os chamadores n�o puderem se recuprar das falhas, lan�e exce��es n�o verificadas
- Caso seja poss�vel a recupera��o e voc� queira for�ar os chamadores a lidar com as condi��es excepcionais, pense primeiro na possibilidade de retornar um opcional

## Item 72: Priorize o uso das exce��es padr�es

- N�o utilizem `Exception`, `RuntimeException`, `Throwable` ou `Error` diretamente. Trate essas classes como se fossem abstratas. Voc� n�o pode testar de forma confiv�vel essas exce��es porque s�o superclasses de outras exce��es que um m�todo pode lan�ar

## Item 73: Lance exce��es adequadas para a abstra��o

- As camadas superiores devem capturar exce��es de n�vel superior e, em seu lugar, lan�ar exce��es que podem ser explicadas em termos da abstra��o de n�vel superior
- Embora a tradu��o da exce��o seja superior � propaga��o descuidada de exce��es das camadas inferiores, n�o deve ser usada em excesso. Sempre que poss�vel, a melhor maneira de ligar com as exce��es das camadas inferiores � evit�-las, garantindo que os m�todos de n�vel mais baixo funcionem. As vezes, voc� pode fazer isso ao verificara validade dos par�metros do m�todo de n�vel superior antes de pass�-los para as camadas inferiores
- Se n�o for poss�vel evitar ou lidar com as exce��es de camadas mais baixas, use a tradu��o de exce��o

## Item 74: Documente todas as exce��es lan�adas para cada m�todo

- Sempre declare as exce��es verificadas indivualmente e documente rigorosamente as condi��es sob as quais cada uma � lan�ada usando a tag do javadoc `@throws`
- Documente principalmente as exce��es n�o verificadas pois representa erros de programa��o e pode ajudar os programadores

## Item 75: Inclua as informa��es a respeito das capturas de falhas nos detalhes da mensagem

- � extramente importante que o m�todo `toString` de exce��o retorne o m�ximo de informa��o poss�vel sobre a causa falha. Em outras palavras, a mensagem detalhada de uma exce��o deve capturar a falha para an�lise posterior
- Para capturar uma falha, a mensagem detalhada de uma exce��o deve conter os valores de todos os par�metros e campos que contribu�ram para a exce��o

## Item 76: Empenhe-se para obter a atomicidade de falha

- Depois que um objeto lan�a uma exce��o, geralmente � desej�vel que o objeto ainda apresente-se em um estado utiliz�vel e bem definido, mesmo se a falha ocorreu no meio da realiza��o de uma opera��o
- De modo geral, uma invoca��o de m�todo com falha deve deixar o objeto no estado em que estava antes da invoca��o
- H� v�rias maneiras de se conseguir esse efeito. A mais simples � projetar objetos imut�veis. Se um objeto � imut�vel, a atomicidade da falha � gratuita

## Item 77: N�o ignore as exce��es

- Um bloco `catch` vazio vai contra o prop�sito das exce��es. Ignorar uma exce��o � parecido com ignorar um alarme de inc�ndio
- Se optar por ignorar uma exce��o, o bloco `catch` deve ter um coment�rio explicando porque e adequado fazer isso, e a vari�vel deve ter o nome `ignored`