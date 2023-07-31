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