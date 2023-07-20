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