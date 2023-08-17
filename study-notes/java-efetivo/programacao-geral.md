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

## Item 63: Cuidado com o desempenho da concatenação de strings

- Usar o operador de concatenação de strings repetidas vezes para concatenar `n` strings requer um tempo quadrático em `n`
- Para se alcançar um desempenho aceitável, utilize uma `StringBuilder` em vez de uma `String` para armazenar a instrução em construção
- Não use o operador de conctenação de string para combinar mais que algumas strings, a menos que o desempenho seja irrelevante. Em vez disso, utilize o método `append` da `StringBuilder`

## Item 64: Referencie os objetos atraves das interfaces deles

- Se existem tipos de interface, apropriados, então, os parâmetrosm os valores de retorno, as variáveis e os campos devem todos ser declarados usando os tipos de interface
- Na prática, deveria ser claro se um determinado objeto tem uma interface apropriada ou não. Caso tenha, seu programa será mais flexível e elegante se você usar a interface para referenciar o objeto. Na hipótese de não haver uma interface adequada, apena use a classe menos específica na hierarquia de classes que disponibilize a funcionalidade exigida

## Item 65: Dê preferência às interfaces em vez da reflexão

- Você pode usufruir dos beneficios da reflexão arcando com poucos dos seus custos, ao usá-la apenas de forma muito limitada. Para muitos programas que devem utilizar uma classe indisponívl no momento da compilação, existe um tempo de compilação uma interaface ou superclasse adequada para referenciar a classe
- Se esse for o caso, você pode criar instâncias de forma reflexiva e acessá-las normalmente através de sua interface ou superclasse
- A reflexão é um recurso poderoso necessário para determinadas tarefas sofisticadas de programação de sistemas, porém apresenta muitas desvantagens. Se você estiver escrevendo um programa que tenha que trabalhar com classes desconhecidas em tempo de compilação, você deve, se possível, usar a reflexão apenas para instanciar e acessar os objetos, e acessá-los usando alguma interface ou superclasse conhecida em tempo de compilação

## Item 66: Utilize os métodos nativos com sabedoria

- Raramente se aconselha usar os métodos nativos com a finalidade de melhorar o desempenho. Nas primeiras versões do Java, muitas vezes era necessário, porem as JVMs tem ficado muito mais rápidas. Agora para a maioria das tarefas, é possível obter um desempenho semelhante no Java.
- O uso dos métodos nativos tem consequências graves. Como as linguaagens nativas não são seguras, as aplicações que usam os métodos nativos não estão imunes a erros de corrupção de memória
- Os programas que usam métodos nativos são menos portáveis. Eles também são bem dificeis de depurar

## Item 67: Seja criterioso ao otimizar

- Procure se esforçar para escrever bons programas em vez de programas rápidos. Se um bom programa não é rápido o bastante, a arquitetura dele permitirár que seja otimizado. Bons programas incorporam o principio da ocultação da informação: sempre que possível, localizam as opções do design dentro dos componenetes individuais, de modo que as opções indivivuais possam ser alteradas sem que afetemo restante do sistema
- A rapidez virá com o tempo
- Quando terminar de construir o sistema, avalie o desempenho dele. Caso seja rápido o bastante, está pronto. Caso não seja, localize a fonte do problema com o auxílio de um profiler e trabalhe na otimização das partes relevantes do sistema. 
- O primeiro é passo é examinar sua ecolha de algoritmos: nenhuma quantidade de otimização de baixo nível pode compensar uma escolha ruim de algoritmo. Repita esse processo conforme necessário, medindo o desempenho após cada alteração, até que esteja satisfeito

## Item 68: Adote as convenções de nomeclatura geralmente aceitas

- Assimile as convenções de nomenclatura padrão, aprenda a usá-las e faça disso um hábito. As convenções tipográficas são simples e em grande parte não apresentam ambiguidades; as convenções gramaticas são mais complexas e mais maleáveis