# Métodos comuns para todos os objetos

## Item 10: Obedeça ao contrato geral ao sobrescrever o `equals`

- A forma mais fácil de se evitar problemas é não sobrescrever o método `equals`, nesses casos, cada instância da classe será igual apenas a si própria. Essa é a coisa certa a fazer se qualquer uma das condições a seguir for verdadeira:

    - **Cada instância da classe é inerentemente exclusiva**. Isso se aplica às classes como thread, que representam entidades ativas em vez de entidades de valores. A implementação do `equals` fornecida pela `Object` tem exatamente o comportamento adequado para essas classes
    - **Não há necessidade de a classe estipular um teste de "igualdade lógica"**. Por exemplo, o `java.util.regex.Pattern` poderia ter sobrescrito o `equals` para verificar se duas instâncias `Pattern` representavam exatamente a mesma expressão regular, todavia os arquitetos acharam que os clientes não precisavam ou não queriam essa funcionalidade.
    - **Uma superclasse que já tenha sobrescrito o `equals` apresenta um comportamento apropriado para essa classe**. Exemplo de uso são as classes `Set` que implementa o `equals` do `Abstractset`
    - **Quando a classe é privada ou pacote privado, e você tem certeza de que seu método não será invocado** Nesse situação realizamos a implementação do `equals` retornando um erro de assertion
- Quando é apropriado sobrescrever o `equals`? Quando uma classe apresenta um sentido de igualdade lógica que diverge da simples identidade do objeto, e quando uma superclasse ainda não sobrescreveu o `equals`
- Uma possível receita de um método `equals` de alta qualidade
1. Use o operador `==` com o propósito de verificar se o argumento é uma referência ao objeto
2. Use o o operador `instanceof` para verificar se o argumento apresenta o tipo correto.
3. Faça o cast do argumento para o tipo correto
4. Para cada campo "significativo" na classe, verifique se o campo do argumento coincide com o correspodente do objeto
5. Sempre sobescreva o `hashCode` ao sobrescrever o `equals`
6. Não substitua `Object` por outro tipo na declaração do `equals`
7. É preferível o uso de IDEs para gerar os métodos `equals` e `hashCode` do que fazer manualmente
8. Faça testes do `equals` se necessário, para verificar o comportamento padrão
9. Não sobrescreve o método, a menos que precise: Em mutos casos, a implementação herdada da Object já traz o resultado satisfatório

## Item 11: Sobrescreva sempre o método `hashCode` ao sobrescrever o método `equals`

- Se não conseguir o fazer, sua classe violará o contrato geral para o `hashCode`, o que impedirá que ele funcione adequadamente nas coleções, como o `HashMap` e `HashSet`
- Ao não sobrescrever o `hashCode`, você viola a segunda regra fundamental: os objetos iguais devem ter hash codes iguais
- Quando você terminar de escrever o método, pergunte-se se as instâncias iguais apresentam hash codes iguais. Desenvolva testes unitários pra comprovar sua intuição (a menos que você use AutoValue para gerar seus métodos equals e os métodos hashCode, situação em que você pode seguramente deixar de fazer esses testes)
- Você deve excluir todos os campos que não são usados nas comparações do `equals`, ou correr o risco de violar a segunda regra do contrato `hashCode`

## Item 12: Sobrescreva sempre o `toString`

- Sobrescreva sempre este método, tornando a mais concisa, mais informativa e que seja legível para uma pessoa
- Fornecer uma boa implementação do método faz com que a classe seja mais agradável de se usar e com que os sistemas que a usam fiquem mais fáceis de depurar
- Quando viável, o método deve retornar todas as informações contidas no objeto
- Não faz sentido escrever o metodo em uma classe utilitária estática. Você também não deve escrever o método para maioria dos tipos enums

## Item 13: Sobrescreva o `clone` de modo sensato

- Espera-se que uma classe ao implementar o `Cloneable` forneça um método `clone` público que funcione corretamente
- Assegure-se que o método não prejudique o objeto original e que implemente adequadamente as invariantes no clone
- A arquitetura da `Cloneable` é incopatível como uso normal dos campos finais que referenciam os objetos mutáveis
- Uma alternativa será fornecer um construtor de cópia ou fábrica de cópia.
- A estratégia do construtor de cópia e sua variante static factory apresentam muitas vantagens em relação a Cloneable/clone: não dependem de um mecanismo decriação de objetos extralinguístico sescetível a risco; não exigem adesão a regras pouco documentadas que não tem como ser impostas; não entram em conflito com o uso apropriado dos campos finais; não lançam exceções verificadas desnecessárias e não precisam de cast
- Via de regra, a funcionalidade de cópia é melhor atendida pelos construtores ou fábricas. Uma exceção digna de nota que foge essa regra são os arrays que são melhores copiados com o método `clone`

## Item 14: Pense na possibilidade de implementar a `Comparable`

- Ao implementar esta classe, você permite que sua classe funcione em conjunto com todos os algoritmos genéricos, que são muitos, e com as implementações de coleção que dependem dessa interface
- Você ganha uma capacidde tremenda em troca de um esforço comum
- As classes que dependem da comparação incluem as coleções ordenadas `TreeSet` e `TreeMap`, as classes utilitárias `Collections` e `Arrays`, que possuem algoritmos de pesquisa e ordenação