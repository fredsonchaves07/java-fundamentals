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