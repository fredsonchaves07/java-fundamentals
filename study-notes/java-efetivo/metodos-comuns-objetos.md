# M�todos comuns para todos os objetos

## Item 10: Obede�a ao contrato geral ao sobrescrever o `equals`

- A forma mais f�cil de se evitar problemas � n�o sobrescrever o m�todo `equals`, nesses casos, cada inst�ncia da classe ser� igual apenas a si pr�pria. Essa � a coisa certa a fazer se qualquer uma das condi��es a seguir for verdadeira:

    - **Cada inst�ncia da classe � inerentemente exclusiva**. Isso se aplica �s classes como thread, que representam entidades ativas em vez de entidades de valores. A implementa��o do `equals` fornecida pela `Object` tem exatamente o comportamento adequado para essas classes
    - **N�o h� necessidade de a classe estipular um teste de "igualdade l�gica"**. Por exemplo, o `java.util.regex.Pattern` poderia ter sobrescrito o `equals` para verificar se duas inst�ncias `Pattern` representavam exatamente a mesma express�o regular, todavia os arquitetos acharam que os clientes n�o precisavam ou n�o queriam essa funcionalidade.
    - **Uma superclasse que j� tenha sobrescrito o `equals` apresenta um comportamento apropriado para essa classe**. Exemplo de uso s�o as classes `Set` que implementa o `equals` do `Abstractset`
    - **Quando a classe � privada ou pacote privado, e voc� tem certeza de que seu m�todo n�o ser� invocado** Nesse situa��o realizamos a implementa��o do `equals` retornando um erro de assertion
- Quando � apropriado sobrescrever o `equals`? Quando uma classe apresenta um sentido de igualdade l�gica que diverge da simples identidade do objeto, e quando uma superclasse ainda n�o sobrescreveu o `equals`
- Uma poss�vel receita de um m�todo `equals` de alta qualidade
1. Use o operador `==` com o prop�sito de verificar se o argumento � uma refer�ncia ao objeto
2. Use o o operador `instanceof` para verificar se o argumento apresenta o tipo correto.
3. Fa�a o cast do argumento para o tipo correto
4. Para cada campo "significativo" na classe, verifique se o campo do argumento coincide com o correspodente do objeto
5. Sempre sobescreva o `hashCode` ao sobrescrever o `equals`
6. N�o substitua `Object` por outro tipo na declara��o do `equals`
7. � prefer�vel o uso de IDEs para gerar os m�todos `equals` e `hashCode` do que fazer manualmente
8. Fa�a testes do `equals` se necess�rio, para verificar o comportamento padr�o
9. N�o sobrescreve o m�todo, a menos que precise: Em mutos casos, a implementa��o herdada da Object j� traz o resultado satisfat�rio

