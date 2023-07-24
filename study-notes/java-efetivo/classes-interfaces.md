# Classes e interfaces

## Item 15: Reduza ao m�nimo a acessibilidade das classes e de seus membros

- O fator mais importante que distingue um componente bem projetado de um com m� qualidade � o grau em que o componente esconde seus dados internos e outros detalhes de implementa��o de outros componentes.
- Um componente bem projetado oculta todos os detalhes de implementa��o, separando cuidadosamente sua API da pr�pria implementa��o.
- Fa�a com que cadaclasse ou membro seja o mais inacess�vel poss�vel
- Se uma classe ou interface pacote-privado de n�vel superior � usada por uma �nica classe, pense na possibilidade de transofmrar essa classe de n�vel superior em uma classe aninhada est�tica privada da �nica classe que a usa. Isso restringe sua acessibilidade apenas � classe que a usa emvez de todas as classes em seu pacote

## Item 16: Use os m�todos getters em classes p�blicas e n�o os campos p�blicos

- Se uma classe � acess�vel fora do seu pacote, forne�a m�todos getters a fim de preservar a flexibilidade para alterar a representa��o interna da classe
- Se uma classe � de pacote privado ou aninhado n�o h� necessidade de utilizar o m�todo getters para expor os campos

## Item 17: Reduza a mutabilidade das classes ao m�nimo

- Uma classe imut�vel � simplesmente uma classe cujas inst�ncias n�o podem ser modificadas. Todas as informa��es contidas em cada inst�ncia s�o fixas durante a vida �til do objeto, portanto, nenhuma altera��o jamais ser� vista.
- As classes imut�veis s�o mais f�ceis de projetas, implementar e de usar do que as mut�veis. Elas est�o sujeitas a poucos erros e s�o mais seguras.
- Para desenvolver uma classe imut�vel, siga esas cinco regras:

1) **N�o forne�a m�todos que modifique o estado do objeto**
2) **Garanta que a classe n�o possa ser estendida**
3) **Fa�a com que todos os campos sejam finais**
4) **Fa�a com que todos os campos sejam privados**
5) **Garanta o acesso exclusivo a quaisquer componentes mut�veis**: Nunca inicialize esse campo em uma refer�ncia de objeto fornecida pelo cliente ou retorne esse campo de um getter. Fa�a copias defensivas em construtores, getters e m�todos `readObject`

## Item 18: Prefira a composi��o � heran�a

- Ao contr�rio da invoca��o do m�todo, a heran�a viola o encapsulamento
- Existe um modo de evitar esses problemas. Em vez de estender uma classe existente, d� � sua classe nova um campo privado, que referencie a inst�ncia de uma classe existente.
- Esse design � chamado de composi��o porque a classe existente se torna um componente da nova classe
- A heran�a � indicada somente em circunst�ncias em que a subclasse realmente � um subtipo da superclasse. Em outras palavras, uma classe B deve estender uma classe A apenas se existir uma rela��o "� um" entre as duas classes

## Item 19: Projete e documente as classes para a heran�a ou a iniba

- A classe deve documentar a autoutiliza��o de m�todos poss�veis de serem sobrescritos
- Para cada m�todo publico ou protegido, a documenta��o deve indicar quais aqueles passs�veis de serem sobrescritos que o m�todo invoca, em que sequ�ncia e como os resultados de cada invoca��o influenciam o pr�ximo processamento
- Se a classe vai ser herdada por heran�a, crie subclasses para testar a superclasse antes de liberar
- Projetar uma classe para heran�a exige muito esfor�o e imp�e limita��es substanciais � classe
- A melhor solu��o para resolver esse problema � inibir a cria��o de subclasse tornando a classe imutavel

## Item 20: Prefira as interfaces em vez de classes abstratas

- As interfaces promovem aprimoramentos seguros e robustos de funcionaldades 
- Podemos combinar as vantagens das interfaces e das classes abstratas, fornecendo uma implementa��o esquel�tica, m�todo default da interface ou classe abstrata separada

## Item 21: Projete as interface para a posteriodade

- Os m�todos padr�es das bibliotecas Java s�o implementa��es de uso geral de alt�ssima qualidade e, na maioria dos casos, funcionaem bem. Mas nem sempre � poss�vel escrever um m�todo padr�o que mantenha todas as invariantes de todas as poss�veis implementa��es
- Deve-se evitar o uso dos m�todos padr�es para adicionar m�todos novoss �s interfaces existentes, a menos que seja crucial, caso em que voc� deve pensar muito bem se uma implementa��o j� existente dessa interface pode ser quebrada por sua implementa��o do m�todo padr�o
- No entando, os m�todos padr�es s�o extremamente �teis para fornecer implementa��es padr�o de m�todos quando uma interface � criada e facilita a tarefa de implementar a interface

## Item 22: Use as interfaces somene para definir tipos

- Quando uma classe implementa uma interface, a interface funciona como um tipo que pode ser usado para se referir a inst�ncias da classe. Portando, quando uma classe implementa uma interface, isso deve dar uma ideia do que o cliente pode fazer com as inst�ncias da classe. N�o � adequado definir uma interface para qualquer outra finalidade
- Um tipo de interface que falha nesse teste � chamada interface constante. Essa interface n�o apresenta m�todos. � composta apenas de campos finais est�ticos, cada qual exportando uma constante
- Se voc� quer exportar as constantes, h� in�meras op��es aceit�veis. Caso as constantes estejam fortemente ligadas a uma classe ou interface existente, voc� deve adicion�-las � classe ou � interface. 
- Se as constantes s�o consideradas como membros de um tipo enumerado, voc� as deve exportar com um tipo `enum`. Caso contr�rio, deve exportar as constantes com uma classe utilit�ria n�o instanci�vel
- Em resumo, as interfaces devem ser usadas somente para definir tipos. Elas n�o devem ser utilizadas apenas para exportar constantes

## Item 23: D� prefer�ncia �s hierarquias declasses em vez das classes tagged

- As classes tagged aprensentam in�meros inconvenientes. Elas est�o repletas de boilerplates, incluindo declara��es enum, campos de tags e instru��es switch. Prejudica-se substancialmente a legiblidade porque existem in�meras implementa��es emaranhadas dentro de uma classe �nica.
- O volume de mem�ria aumenta, pois as inst�ncias s�o carregadas com campos irrelevantes pertencentes �s outras op��es.
- Para transformar uma classe tagged em uma hierarquia de classes, primeiro, defina uma classe abstrata com um m�todo abstrato para cada m�todo na classe tagged cujo comportamento depena do valor da tag
- Em seguida, defina uma subclasse concreta da classe raiz para cada op��o da classe tagged original
- A implementa��o de cada op��o � atribuida � pr�pria classe, e nenhuma dessas classes � sobrecarregada por campos de dados irrelevantes. Todos os campos s�o finais. O compilador assegura que o construtor de cada classe inicialize seus campos de dados e que cada classe tenha uma implementa��o para cada m�todo abstrato declarado na classe raiz

## Item 24: Prefira as classes membros est�ticas �s n�o est�ticas

- Uma classe aninhada � definida dentro de outra. Uma classe aninhada deve existir apenas para atender a sua classe enolvente. Se uma classe aninhada for de utilidade em algum outro contexto, ent�o, deveria ser uma classe de n�vel superior
- H� quatros tipos de classe aninhadas: classes de membro est�ticas, membro n�o est�ticas, an�nimas e locais
- Se voc� declara uma classe membro que n�o exija acesso a uma inst�ncia envolvente, coloque sempre o modificador `static` em sua declara��o
- Armazena essa refer�ncia exigem tempo e espa�o. Mais grave, isso pode provocar a reten��o da inst�ncia envolvente em vez de ela ficar eleg�vel para o garbage collector. o vazamento de mem�ria resultante pode ser catastr�fico. Muitas vezes, � dif�cil de detect�-lo, porque a refer�ncia � invis�vel.
- Antes de os lambdas serem introduzidos no java, as classes an�nimas eram os meios preferidos para criar pequenos objetos de fun��o e objetos de processo na hora, mas agora o mais recomendado s�o os lambda

## Item 25: Limite os arquivos fonte a uma �nica classe de n�vel superior

- Mesmo que o compilador Java permita que voc� defina v�rias classes de n�vel superior em um �nico arquivo fonte, n�o h� vantagens associadas a isso, e h� riscos significativos.
- Os riscos decorrem do fato de que a defini��o de m�ltiplas classes de n�vel superior em um arquivo fonte faz com que seja poss�vel fornecer v�rias defini��es para uma classe
- Na hip�tese de voc� se sentir tentado a inserir v�rias classes de n�vel superior em um �nico arquivo fonte, pense na possibildiade de usar as classes membro est�ticas como uma alternativa � divis�o de classes em arquvios fontes separados.
- Se as classes s�o subordinadas � outra, em geral, transform�-las em classes membros est�ticas � a melhor alternativa porque aumenta a legibilidade e faz com que seja poss�vel reduzir a acessibilidade das classes as declarando como privadas