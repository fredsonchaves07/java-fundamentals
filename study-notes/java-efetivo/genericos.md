# Genericos

## Item 26: Não use tipos brutos

- Permite-use a utilização de tipos brutos, porém você nunca deve usar. Se você usar os tipos brutos, abrirá mão de todas as vantagens de segurança e expressividade oferecidasd pelos genéricos
- Perdemos a type safety caso usamos o tipo bruto com `List`, mas não se usar um tipo parametrizado com o `List<Object`
- Caso não saiba ou se importe com o formato do parâmetro real, podemos utizar os wildcards
- Em síntese, o uso dos tipos brutos provoca exceções em tempo de execução, portanto, não os utilize. Eles são disponibilizados exclusivamente para a compatibilidade e a interoperabilidade com códigos legados anteriores à introdução dos genéricos na plataforma Java.

## Item 27: Elimine as advertências não verificadas

- Ao programar com genéricos, você verá que o compilador gera muitas advertências: de cast não verificado, de invocação de métodos não verificados, de tipo vararg parametrizado não verificado e de conversões não verificadas
- Elimine todas as advertências não verificadas que conseguir. Ao eliminar todas elas, você garante que sej código seja typesafe, o que é uma coisa muito boa
- Caso não consiga eliminar uma advertência, mas consiga comprovar que o código que a provocou é typesafe, então (somente nesse caso) suprima a advertência com uma anotação `@SuppressWarnings("unchecked")`
- Toda vez que você usar a anotação `@SupressWarnings("unchecked")` adicione um comentário dizendo porque é seguro utiliza-la

## Item 28: Prefira as listas aos arrays

- Os arrays distinguem-se dos tipos genéricos de duas formas importantes. Em primeiro lugar, os arrays são convariantes. Os genéricos são invariantes
- Os arrays proporcionam type safety em tempo de execução, mas na hora de compilação, e o contrário se aplica aos genéricos.
- Via de regra, os arrays e os genéricos não se combina bem. É interessante por conta disso, substituir os arrays por listas

## Item 29: Priorize os tipos genéricos

- Os tipos genéricos são mais seguros e fáceis de se utilizar do que os que exigem a realização de casts no código cliente. Ao projetar tipos novos, provicencie que possam ser usados sem esses casts
- Muitas vezes, isso significará transform-alos em tipos genéricos. Caso tenha quaisquer tipos existentes que deveriam ser genéricos, mas não o sejam, generifique-os

## Item 30: Priorize os métodos genéricos

- Os métodos genéricos, como os tipos genéricos, são mais seguros e fáceis de usar do que os métodos que exigem de seus clientes a nserção de casts explicitos nos parâmetros de entrada e nos valores de retorno
- Certifique-se de que seus métodos possam ser utilizados sem casts, o que, muitas vezes, significa transformá-los em genéricos

## Item 31: Use os wildcards limitados para aumentar a flexibilidade da API

- Para maximizar a flexibilidade, use os tipos wildcards nos parâmetros de entrada que representam os produtores e os consumidores
- Quando usados apropriadamente, os tipos wildcard são quase invisíveis para os usuarios de uma classe. Eles fazem os métodos aceitarem parâmetros que deveriam aceitar e rejeitarem aqueles que deveriam rejeitar. Caso o usuário de uma classe tenha que pensar sobre tipos wildcard, provavelmente há algo de errado com a API dela
- Se você escrever uma biblioteca que será muito utilizada, o uso adequado dos tipos wildcards deve ser considerado imprescindível

## Item 32: Seja criterioso ao combinar os genéricos com varargs

- A finalidade dos varargs é possibilitar que os clientes passem um número variável de argumentos para um método; todavia, isso é um vazamento de abstração: ao invocar os métodos vargars, cria-se um array para que os parâmetros varargs sejam mantidos
- Você recebe uma série de advertências confusasdo compilador quando os parâmetros varargs tem tipos parametrizados ou genéricos
- Use `@SafeVarargs` em cada método com um parâmetro varargs de um tipo parametrizado ou genérico, de modo que seus usuários não sejam sobrecarregados por advertências confusas e desencessárias do compilador
- Toda vez que o compilador lhe advertir de uma possível poluição do heap advinda de um parâmetro vargs genérico em um método que você controla, verifique se é seguro
- Em suma, varargs e genéricos não interagem bem em virtude de os recursos dos varargs serem vazamento de abstração constuído sobre os arrays, e de os arrays terem regras de tipagem diferentes dos genéricos
- Garanta que o método seja typesafe, e depois anote-o com `@SafeVarargs`

## Item 32: Pense na possibilidade de usar contêiners heterogêneos typesafe

- As vezes você precisa de mais flexibilidade. Por exemplo, uma linha de banco de dados pode arbitrariamente apresentar muitas colunas, e seria bom conseguir acessar todas elas de um modo ypesafe. Por sorte, existe uma maneira fácil de se realizar essa tarefa.
- Trata-se de parametrizar a chave em vez do contêiner. Em seguida, apresentar a chave parametrizada ao contêiner para inserir ou recuprar um valor. O sistema de tipos genéricos é utilizada para garantir que o tipo de valor esteja de acordo com sua chave
- Você pode utilizar objetos `Class` como chaves para tais contêineres heterogêneos typesafe. Um objeto `Class`, quando usado desse modo, chama-se token de tipo
- Você também pode utilizar um tipo de chave customizado. Por exemplo, você pode ter um tipo `DatabaseRow` representando uma linha de banco de dados (o contêiner), e um tipo genérico `Column<T>` como sua chave

