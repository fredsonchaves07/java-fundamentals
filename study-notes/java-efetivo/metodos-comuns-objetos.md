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

## Item 11: Sobrescreva sempre o m�todo `hashCode` ao sobrescrever o m�todo `equals`

- Se n�o conseguir o fazer, sua classe violar� o contrato geral para o `hashCode`, o que impedir� que ele funcione adequadamente nas cole��es, como o `HashMap` e `HashSet`
- Ao n�o sobrescrever o `hashCode`, voc� viola a segunda regra fundamental: os objetos iguais devem ter hash codes iguais
- Quando voc� terminar de escrever o m�todo, pergunte-se se as inst�ncias iguais apresentam hash codes iguais. Desenvolva testes unit�rios pra comprovar sua intui��o (a menos que voc� use AutoValue para gerar seus m�todos equals e os m�todos hashCode, situa��o em que voc� pode seguramente deixar de fazer esses testes)
- Voc� deve excluir todos os campos que n�o s�o usados nas compara��es do `equals`, ou correr o risco de violar a segunda regra do contrato `hashCode`

## Item 12: Sobrescreva sempre o `toString`

- Sobrescreva sempre este m�todo, tornando a mais concisa, mais informativa e que seja leg�vel para uma pessoa
- Fornecer uma boa implementa��o do m�todo faz com que a classe seja mais agrad�vel de se usar e com que os sistemas que a usam fiquem mais f�ceis de depurar
- Quando vi�vel, o m�todo deve retornar todas as informa��es contidas no objeto
- N�o faz sentido escrever o metodo em uma classe utilit�ria est�tica. Voc� tamb�m n�o deve escrever o m�todo para maioria dos tipos enums

## Item 13: Sobrescreva o `clone` de modo sensato

- Espera-se que uma classe ao implementar o `Cloneable` forne�a um m�todo `clone` p�blico que funcione corretamente
- Assegure-se que o m�todo n�o prejudique o objeto original e que implemente adequadamente as invariantes no clone
- A arquitetura da `Cloneable` � incopat�vel como uso normal dos campos finais que referenciam os objetos mut�veis
- Uma alternativa ser� fornecer um construtor de c�pia ou f�brica de c�pia.
- A estrat�gia do construtor de c�pia e sua variante static factory apresentam muitas vantagens em rela��o a Cloneable/clone: n�o dependem de um mecanismo decria��o de objetos extralingu�stico sescet�vel a risco; n�o exigem ades�o a regras pouco documentadas que n�o tem como ser impostas; n�o entram em conflito com o uso apropriado dos campos finais; n�o lan�am exce��es verificadas desnecess�rias e n�o precisam de cast
- Via de regra, a funcionalidade de c�pia � melhor atendida pelos construtores ou f�bricas. Uma exce��o digna de nota que foge essa regra s�o os arrays que s�o melhores copiados com o m�todo `clone`

## Item 14: Pense na possibilidade de implementar a `Comparable`

- Ao implementar esta classe, voc� permite que sua classe funcione em conjunto com todos os algoritmos gen�ricos, que s�o muitos, e com as implementa��es de cole��o que dependem dessa interface
- Voc� ganha uma capacidde tremenda em troca de um esfor�o comum
- As classes que dependem da compara��o incluem as cole��es ordenadas `TreeSet` e `TreeMap`, as classes utilit�rias `Collections` e `Arrays`, que possuem algoritmos de pesquisa e ordena��o