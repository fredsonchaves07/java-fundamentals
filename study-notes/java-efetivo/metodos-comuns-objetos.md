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

