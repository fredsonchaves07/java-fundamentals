# Programação geral

## Item 57: Minimize o escopo das variáveis locais

- Ao minimizar o escopo das variáveis locais, você aumenta a legibilidade e a facilidade de manutenção do seu código e reduz as probabilidades de erro
- A técnica mais poderosa para minimizar o escopo de uma variável local é declará-la onde ela será utilizada pela primeira vez
- Uma última técnica para minimizar o escopo das variáveis locais é manter os métodos pequenos e focados. Se combinar duas atividades no mesmo método, as variáveis locais relevantes para uma atividade podem estar no escopo do código que executa a outra atividade. Para evitar que isso aconteça, basta dividir o método em dois: um para cada atividade

## Item 58: Dê preferência aos loops for-each em vez dos tradicionais loops for

- Os loops for each são mais perfomáticos e simples de fazer manutenção
- Caso você esteja escrevendo um tipo que representa um grupo de elementos, você deve seriamente pensar em implementar a `Iterable`, mesmo que escolha não implementar a `Collection`. Isso permitirá que seus usuários façam uma iteração sobre seu tipo usando o for-each

## Item 59: Conheça e utilize as bibliotecas

- Ao usar uma biblioteca padrão, você usufrui do conhecimento dos especialistas que escreveram e da experiência daqueles que a utilizaram antes de você
- Adicionam-se numerosas funcionalidades às bibliotecas a cada versão, e vale a pena estar a par destas edições

## Item 60: Evite o `float` e `double` caso sejam necessárias respostas exatas

- Os tipos `float` e `double` são particularmente inadequados para cálculos monetários, dado que é impossível representar exatamente 0,1 (ou qualquer outra potência negativa de dez) como um `float` ou um `double`
- Use a `BigDecimal`, o `int` ou `long` para cálculos monetários

## Item 61: Dê preferência aos tipos primitivos em vez dos tipos primitivos empacotados

- Utilize os tipos primitivos em vez dos primitivos empacotados sempre que você tiver a chance
- Os tipos primitivos são mais simples e mais rápidos
- O autoboxing reduz a verbosidade, mas não o periodo de se usar os primitivos empacotados
- Quando o seu programa realiza cálculos de tipos misturados que envolvem primitivos empacotados e desempacotados, ele exructa o procedimento de unboxing, e quando o seu programa faz o unboxing, ele pode laçr uma `NullPointerException`

## Item 62: Evite as strings onde outros tipos forem mais adequados

- De um modo geral, se houver um tipo de valor apropriado, seja ele primitivo ou uma referência de objeto, você deve usá-lo; se não houve, você deve escrever um
- Usadas de forma inadequada, as strings são mais pesadas, menos maleáveis, mais lentas e mais propensas a erros do que os outros tipos. As Strings são comumente mal usada para represenar tipos primitivos, enums e tipos agregados