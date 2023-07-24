# Classes e interfaces

## Item 15: Reduza ao mínimo a acessibilidade das classes e de seus membros

- O fator mais importante que distingue um componente bem projetado de um com má qualidade é o grau em que o componente esconde seus dados internos e outros detalhes de implementação de outros componentes.
- Um componente bem projetado oculta todos os detalhes de implementação, separando cuidadosamente sua API da própria implementação.
- Faça com que cadaclasse ou membro seja o mais inacessível possível
- Se uma classe ou interface pacote-privado de nível superior é usada por uma única classe, pense na possibilidade de transofmrar essa classe de nível superior em uma classe aninhada estática privada da única classe que a usa. Isso restringe sua acessibilidade apenas à classe que a usa emvez de todas as classes em seu pacote

## Item 16: Use os métodos getters em classes públicas e não os campos públicos

- Se uma classe é acessível fora do seu pacote, forneça métodos getters a fim de preservar a flexibilidade para alterar a representação interna da classe
- Se uma classe é de pacote privado ou aninhado não há necessidade de utilizar o método getters para expor os campos

## Item 17: Reduza a mutabilidade das classes ao mínimo

- Uma classe imutável é simplesmente uma classe cujas instâncias não podem ser modificadas. Todas as informações contidas em cada instância são fixas durante a vida útil do objeto, portanto, nenhuma alteração jamais será vista.
- As classes imutáveis são mais fáceis de projetas, implementar e de usar do que as mutáveis. Elas estão sujeitas a poucos erros e são mais seguras.
- Para desenvolver uma classe imutável, siga esas cinco regras:

1) **Não forneça métodos que modifique o estado do objeto**
2) **Garanta que a classe não possa ser estendida**
3) **Faça com que todos os campos sejam finais**
4) **Faça com que todos os campos sejam privados**
5) **Garanta o acesso exclusivo a quaisquer componentes mutáveis**: Nunca inicialize esse campo em uma referência de objeto fornecida pelo cliente ou retorne esse campo de um getter. Faça copias defensivas em construtores, getters e métodos `readObject`

## Item 18: Prefira a composição à herança

- Ao contrário da invocação do método, a herança viola o encapsulamento
- Existe um modo de evitar esses problemas. Em vez de estender uma classe existente, dê à sua classe nova um campo privado, que referencie a instância de uma classe existente.
- Esse design é chamado de composição porque a classe existente se torna um componente da nova classe
- A herança é indicada somente em circunstâncias em que a subclasse realmente é um subtipo da superclasse. Em outras palavras, uma classe B deve estender uma classe A apenas se existir uma relação "É um" entre as duas classes

## Item 19: Projete e documente as classes para a herança ou a iniba

- A classe deve documentar a autoutilização de métodos possíveis de serem sobrescritos
- Para cada método publico ou protegido, a documentação deve indicar quais aqueles passsíveis de serem sobrescritos que o método invoca, em que sequência e como os resultados de cada invocação influenciam o próximo processamento
- Se a classe vai ser herdada por herança, crie subclasses para testar a superclasse antes de liberar
- Projetar uma classe para herança exige muito esforço e impõe limitações substanciais à classe
- A melhor solução para resolver esse problema é inibir a criação de subclasse tornando a classe imutavel

## Item 20: Prefira as interfaces em vez de classes abstratas

- As interfaces promovem aprimoramentos seguros e robustos de funcionaldades 
- Podemos combinar as vantagens das interfaces e das classes abstratas, fornecendo uma implementação esquelética, método default da interface ou classe abstrata separada

## Item 21: Projete as interface para a posteriodade

- Os métodos padrões das bibliotecas Java são implementações de uso geral de altíssima qualidade e, na maioria dos casos, funcionaem bem. Mas nem sempre é possível escrever um método padrão que mantenha todas as invariantes de todas as possíveis implementações
- Deve-se evitar o uso dos métodos padrões para adicionar métodos novoss às interfaces existentes, a menos que seja crucial, caso em que você deve pensar muito bem se uma implementação já existente dessa interface pode ser quebrada por sua implementação do método padrão
- No entando, os métodos padrões são extremamente úteis para fornecer implementações padrão de métodos quando uma interface é criada e facilita a tarefa de implementar a interface

## Item 22: Use as interfaces somene para definir tipos

- Quando uma classe implementa uma interface, a interface funciona como um tipo que pode ser usado para se referir a instâncias da classe. Portando, quando uma classe implementa uma interface, isso deve dar uma ideia do que o cliente pode fazer com as instâncias da classe. Não é adequado definir uma interface para qualquer outra finalidade
- Um tipo de interface que falha nesse teste é chamada interface constante. Essa interface não apresenta métodos. É composta apenas de campos finais estáticos, cada qual exportando uma constante
- Se você quer exportar as constantes, há inúmeras opções aceitáveis. Caso as constantes estejam fortemente ligadas a uma classe ou interface existente, você deve adicioná-las à classe ou à interface. 
- Se as constantes são consideradas como membros de um tipo enumerado, você as deve exportar com um tipo `enum`. Caso contrário, deve exportar as constantes com uma classe utilitária não instanciável
- Em resumo, as interfaces devem ser usadas somente para definir tipos. Elas não devem ser utilizadas apenas para exportar constantes

## Item 23: Dê preferência às hierarquias declasses em vez das classes tagged

- As classes tagged aprensentam inúmeros inconvenientes. Elas estão repletas de boilerplates, incluindo declarações enum, campos de tags e instruções switch. Prejudica-se substancialmente a legiblidade porque existem inúmeras implementações emaranhadas dentro de uma classe única.
- O volume de memória aumenta, pois as instâncias são carregadas com campos irrelevantes pertencentes às outras opções.
- Para transformar uma classe tagged em uma hierarquia de classes, primeiro, defina uma classe abstrata com um método abstrato para cada método na classe tagged cujo comportamento depena do valor da tag
- Em seguida, defina uma subclasse concreta da classe raiz para cada opção da classe tagged original
- A implementação de cada opção é atribuida à própria classe, e nenhuma dessas classes é sobrecarregada por campos de dados irrelevantes. Todos os campos são finais. O compilador assegura que o construtor de cada classe inicialize seus campos de dados e que cada classe tenha uma implementação para cada método abstrato declarado na classe raiz

## Item 24: Prefira as classes membros estáticas às não estáticas

- Uma classe aninhada é definida dentro de outra. Uma classe aninhada deve existir apenas para atender a sua classe enolvente. Se uma classe aninhada for de utilidade em algum outro contexto, então, deveria ser uma classe de nível superior
- Há quatros tipos de classe aninhadas: classes de membro estáticas, membro não estáticas, anônimas e locais
- Se você declara uma classe membro que não exija acesso a uma instância envolvente, coloque sempre o modificador `static` em sua declaração
- Armazena essa referência exigem tempo e espaço. Mais grave, isso pode provocar a retenção da instância envolvente em vez de ela ficar elegível para o garbage collector. o vazamento de memória resultante pode ser catastrófico. Muitas vezes, é difícil de detectá-lo, porque a referência é invisível.
- Antes de os lambdas serem introduzidos no java, as classes anônimas eram os meios preferidos para criar pequenos objetos de função e objetos de processo na hora, mas agora o mais recomendado são os lambda

## Item 25: Limite os arquivos fonte a uma única classe de nível superior

- Mesmo que o compilador Java permita que você defina várias classes de nível superior em um único arquivo fonte, não há vantagens associadas a isso, e há riscos significativos.
- Os riscos decorrem do fato de que a definição de múltiplas classes de nível superior em um arquivo fonte faz com que seja possível fornecer várias definições para uma classe
- Na hipótese de você se sentir tentado a inserir várias classes de nível superior em um único arquivo fonte, pense na possibildiade de usar as classes membro estáticas como uma alternativa à divisão de classes em arquvios fontes separados.
- Se as classes são subordinadas à outra, em geral, transformá-las em classes membros estáticas é a melhor alternativa porque aumenta a legibilidade e faz com que seja possível reduzir a acessibilidade das classes as declarando como privadas