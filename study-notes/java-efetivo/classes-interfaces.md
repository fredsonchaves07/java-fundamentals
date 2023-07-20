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