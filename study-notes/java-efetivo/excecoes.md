# Exceções

## Item 69: Utilize as exceções somente em circustâncias excepcionais

- As exceções são, como o nome sugere, para ser usadas apenas em circustâncias excepcionais; nunca se deve usá-las para o controle de fluxo normal

## Item 70: Utilize as exceções verificadas para condições recuperáveis e exceções de runtime para erros de programação

- Utilize as exceções verificadas para as condições das quais o chamador possa razoavelmente se recuperar. Ao lançar uma exceção verificada, você força o chamador a lidar com a cláusula `catch` ou a propagar para o exterior
- Utilize as exceções de runtime para indicar erros de programação
- Todas as throwables não verificadas que você implementardevem ser subclasses da `RuntimeException`

## Item 71: Evite o uso desnecessário das exceções verificadas

- Quando usadas com moderação, as exceções verificadas aumenta a confiabilidade dos programas; quando usadas em excesso, fazem com que as APIs sejam dificeis de se utilizar
- Se os chamadores não puderem se recuprar das falhas, lançe exceções não verificadas
- Caso seja possível a recuperação e você queira forçar os chamadores a lidar com as condições excepcionais, pense primeiro na possibilidade de retornar um opcional

## Item 72: Priorize o uso das exceções padrões

- Não utilizem `Exception`, `RuntimeException`, `Throwable` ou `Error` diretamente. Trate essas classes como se fossem abstratas. Você não pode testar de forma confivável essas exceções porque são superclasses de outras exceções que um método pode lançar

## Item 73: Lance exceções adequadas para a abstração

- As camadas superiores devem capturar exceções de nível superior e, em seu lugar, lançar exceções que podem ser explicadas em termos da abstração de nível superior
- Embora a tradução da exceção seja superior à propagação descuidada de exceções das camadas inferiores, não deve ser usada em excesso. Sempre que possível, a melhor maneira de ligar com as exceções das camadas inferiores é evitá-las, garantindo que os métodos de nível mais baixo funcionem. As vezes, você pode fazer isso ao verificara validade dos parâmetros do método de nível superior antes de passá-los para as camadas inferiores
- Se não for possível evitar ou lidar com as exceções de camadas mais baixas, use a tradução de exceção

## Item 74: Documente todas as exceções lançadas para cada método

- Sempre declare as exceções verificadas indivualmente e documente rigorosamente as condições sob as quais cada uma é lançada usando a tag do javadoc `@throws`
- Documente principalmente as exceções não verificadas pois representa erros de programação e pode ajudar os programadores

## Item 75: Inclua as informações a respeito das capturas de falhas nos detalhes da mensagem

- É extramente importante que o método `toString` de exceção retorne o máximo de informação possível sobre a causa falha. Em outras palavras, a mensagem detalhada de uma exceção deve capturar a falha para análise posterior
- Para capturar uma falha, a mensagem detalhada de uma exceção deve conter os valores de todos os parâmetros e campos que contribuíram para a exceção

## Item 76: Empenhe-se para obter a atomicidade de falha

- Depois que um objeto lança uma exceção, geralmente é desejável que o objeto ainda apresente-se em um estado utilizável e bem definido, mesmo se a falha ocorreu no meio da realização de uma operação
- De modo geral, uma invocação de método com falha deve deixar o objeto no estado em que estava antes da invocação
- Há várias maneiras de se conseguir esse efeito. A mais simples é projetar objetos imutáveis. Se um objeto é imutável, a atomicidade da falha é gratuita

## Item 77: Não ignore as exceções

- Um bloco `catch` vazio vai contra o propósito das exceções. Ignorar uma exceção é parecido com ignorar um alarme de incêndio
- Se optar por ignorar uma exceção, o bloco `catch` deve ter um comentário explicando porque e adequado fazer isso, e a variável deve ter o nome `ignored`