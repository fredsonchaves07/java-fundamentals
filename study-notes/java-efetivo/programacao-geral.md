# Programa��o geral

## Item 57: Minimize o escopo das vari�veis locais

- Ao minimizar o escopo das vari�veis locais, voc� aumenta a legibilidade e a facilidade de manuten��o do seu c�digo e reduz as probabilidades de erro
- A t�cnica mais poderosa para minimizar o escopo de uma vari�vel local � declar�-la onde ela ser� utilizada pela primeira vez
- Uma �ltima t�cnica para minimizar o escopo das vari�veis locais � manter os m�todos pequenos e focados. Se combinar duas atividades no mesmo m�todo, as vari�veis locais relevantes para uma atividade podem estar no escopo do c�digo que executa a outra atividade. Para evitar que isso aconte�a, basta dividir o m�todo em dois: um para cada atividade

## Item 58: D� prefer�ncia aos loops for-each em vez dos tradicionais loops for

- Os loops for each s�o mais perfom�ticos e simples de fazer manuten��o
- Caso voc� esteja escrevendo um tipo que representa um grupo de elementos, voc� deve seriamente pensar em implementar a `Iterable`, mesmo que escolha n�o implementar a `Collection`. Isso permitir� que seus usu�rios fa�am uma itera��o sobre seu tipo usando o for-each

## Item 59: Conhe�a e utilize as bibliotecas

- Ao usar uma biblioteca padr�o, voc� usufrui do conhecimento dos especialistas que escreveram e da experi�ncia daqueles que a utilizaram antes de voc�
- Adicionam-se numerosas funcionalidades �s bibliotecas a cada vers�o, e vale a pena estar a par destas edi��es

## Item 60: Evite o `float` e `double` caso sejam necess�rias respostas exatas

- Os tipos `float` e `double` s�o particularmente inadequados para c�lculos monet�rios, dado que � imposs�vel representar exatamente 0,1 (ou qualquer outra pot�ncia negativa de dez) como um `float` ou um `double`
- Use a `BigDecimal`, o `int` ou `long` para c�lculos monet�rios

## Item 61: D� prefer�ncia aos tipos primitivos em vez dos tipos primitivos empacotados

- Utilize os tipos primitivos em vez dos primitivos empacotados sempre que voc� tiver a chance
- Os tipos primitivos s�o mais simples e mais r�pidos
- O autoboxing reduz a verbosidade, mas n�o o periodo de se usar os primitivos empacotados
- Quando o seu programa realiza c�lculos de tipos misturados que envolvem primitivos empacotados e desempacotados, ele exructa o procedimento de unboxing, e quando o seu programa faz o unboxing, ele pode la�r uma `NullPointerException`

## Item 62: Evite as strings onde outros tipos forem mais adequados

- De um modo geral, se houver um tipo de valor apropriado, seja ele primitivo ou uma refer�ncia de objeto, voc� deve us�-lo; se n�o houve, voc� deve escrever um
- Usadas de forma inadequada, as strings s�o mais pesadas, menos male�veis, mais lentas e mais propensas a erros do que os outros tipos. As Strings s�o comumente mal usada para represenar tipos primitivos, enums e tipos agregados

## Item 63: Cuidado com o desempenho da concatena��o de strings

- Usar o operador de concatena��o de strings repetidas vezes para concatenar `n` strings requer um tempo quadr�tico em `n`
- Para se alcan�ar um desempenho aceit�vel, utilize uma `StringBuilder` em vez de uma `String` para armazenar a instru��o em constru��o
- N�o use o operador de conctena��o de string para combinar mais que algumas strings, a menos que o desempenho seja irrelevante. Em vez disso, utilize o m�todo `append` da `StringBuilder`

## Item 64: Referencie os objetos atraves das interfaces deles

- Se existem tipos de interface, apropriados, ent�o, os par�metrosm os valores de retorno, as vari�veis e os campos devem todos ser declarados usando os tipos de interface
- Na pr�tica, deveria ser claro se um determinado objeto tem uma interface apropriada ou n�o. Caso tenha, seu programa ser� mais flex�vel e elegante se voc� usar a interface para referenciar o objeto. Na hip�tese de n�o haver uma interface adequada, apena use a classe menos espec�fica na hierarquia de classes que disponibilize a funcionalidade exigida

## Item 65: D� prefer�ncia �s interfaces em vez da reflex�o

- Voc� pode usufruir dos beneficios da reflex�o arcando com poucos dos seus custos, ao us�-la apenas de forma muito limitada. Para muitos programas que devem utilizar uma classe indispon�vl no momento da compila��o, existe um tempo de compila��o uma interaface ou superclasse adequada para referenciar a classe
- Se esse for o caso, voc� pode criar inst�ncias de forma reflexiva e acess�-las normalmente atrav�s de sua interface ou superclasse
- A reflex�o � um recurso poderoso necess�rio para determinadas tarefas sofisticadas de programa��o de sistemas, por�m apresenta muitas desvantagens. Se voc� estiver escrevendo um programa que tenha que trabalhar com classes desconhecidas em tempo de compila��o, voc� deve, se poss�vel, usar a reflex�o apenas para instanciar e acessar os objetos, e acess�-los usando alguma interface ou superclasse conhecida em tempo de compila��o

## Item 66: Utilize os m�todos nativos com sabedoria

- Raramente se aconselha usar os m�todos nativos com a finalidade de melhorar o desempenho. Nas primeiras vers�es do Java, muitas vezes era necess�rio, porem as JVMs tem ficado muito mais r�pidas. Agora para a maioria das tarefas, � poss�vel obter um desempenho semelhante no Java.
- O uso dos m�todos nativos tem consequ�ncias graves. Como as linguaagens nativas n�o s�o seguras, as aplica��es que usam os m�todos nativos n�o est�o imunes a erros de corrup��o de mem�ria
- Os programas que usam m�todos nativos s�o menos port�veis. Eles tamb�m s�o bem dificeis de depurar

## Item 67: Seja criterioso ao otimizar

- Procure se esfor�ar para escrever bons programas em vez de programas r�pidos. Se um bom programa n�o � r�pido o bastante, a arquitetura dele permitir�r que seja otimizado. Bons programas incorporam o principio da oculta��o da informa��o: sempre que poss�vel, localizam as op��es do design dentro dos componenetes individuais, de modo que as op��es indivivuais possam ser alteradas sem que afetemo restante do sistema
- A rapidez vir� com o tempo
- Quando terminar de construir o sistema, avalie o desempenho dele. Caso seja r�pido o bastante, est� pronto. Caso n�o seja, localize a fonte do problema com o aux�lio de um profiler e trabalhe na otimiza��o das partes relevantes do sistema. 
- O primeiro � passo � examinar sua ecolha de algoritmos: nenhuma quantidade de otimiza��o de baixo n�vel pode compensar uma escolha ruim de algoritmo. Repita esse processo conforme necess�rio, medindo o desempenho ap�s cada altera��o, at� que esteja satisfeito

## Item 68: Adote as conven��es de nomeclatura geralmente aceitas

- Assimile as conven��es de nomenclatura padr�o, aprenda a us�-las e fa�a disso um h�bito. As conven��es tipogr�ficas s�o simples e em grande parte n�o apresentam ambiguidades; as conven��es gramaticas s�o mais complexas e mais male�veis