# Criar e destruir objetos

## 1) Considere os métodos static factory em vez de construtores

- Alternativa ao modo tradicional de instanciar uma classe. Podemos fornecer um método static factory publico que retorna uma instância de uma classe
- Uma das vantagens dos métodos static factory é que, ao contrário dos construtores, eles tem nômes. Ou seja, é mais fácil de lê e entender o fluxo do código
- A segunda vantagem dos métodos static factory é que, ao contrário dos construtores, não precisam criar um novo objeto sempre que invocados. Essa abordagem é semelhante ao padrão Flyweigh. Ela melhora significativamente o desempenho caso os objetos equivalentes sejam requisitados com frequẽncia, principalmente se a criação deles for custosa
- A terceira vantagem é que, ao contrário dos construtores, podem retonar um objeto de qualquer subtipo do próprio tipo de retorno.
- A quarta vantagem é que a classe do objeto retornado pode variar de chamada para chamada, em função dos parâmetros de entrada. Um exemplo de classe que utiliza essa abordagem é a `EnumSet`
- A quinta vantagem dis static factories é que não precisa existir a classe do objeto retornado quando a classe contém o método de escrita. Muito utilizado em frameworks de injeção de dependencia
- A principal limitação de fornecer apenas métodos static factory é que as classes sem construtores públicos ou protegidos não podem ser divididas em sublcasses.
- Outra principal limitação é que esses métodos são dificeis de ser encontrados pelo programadores
- Em suma, tanto os métodos static factory como os construtores públicos têm seus usos, e vale a pena compreender seus respectivos pontos positivos. Não raro, recomenda-se o uso dos métodos static factoy, assim, evita-se os impulso de empregar construtores públicos sem antes levar em consideraração as static factories

## 2) Cogite o uso de um builder quando se deparar com muitos parâmetros no construtor

- Para resolver esta questão, tradicionalmente, os programadores têm usado o padrão `telescoping constructor`, no qual você fornece um construtor somente com os parâmetros necessários, outro com um único parâmetro opcional, um terceiro com dois e assim sucessivamente. O padrão telescoping constructor funciona, mas é difícil escrever código do cliente quando se tem muitos parâmetros, e é ainda mais difícil de ler.
- Uma alternativa eficiente seria utilizar o padrão `Builder`. Em vez de construir diretamente o objeto pretendido, o cliente chama um construtor (ou uma static factory) com todos os parâmetros necessários e obtém um objeto builder, Em seguida, o cliente chama o método do tipo setter no objeto builder para definir cada parâmetro opcional de interesse. Por fim, o cliente chama um método builder sem parâmetros para gerar o objeto, nomalmente imultavel. Em geral, o builder é um membro de classe estática
- O padrão Builder simula os parâmetros opcionais nomeados como os que encontramos nas linguagens Python e Scala.
- O padrão Builder também apresenta desvantagens. Para criar um objeto, você deve primeiro criar um builder. Embora seja pouco provável que o custo de criação desse builder seja considerável na prática, isso pode ser um problema em situações críticas de desempenho. Além disso, o padrão Builder é mais verboso do que o padrão do telescoping constructor, logo, ele deve ser usado apenas se houver parâmetros suficientes que justifiquem seu uso, digamos que quatro parâmetros ou mais.
- Em síntese, o padrão Builder é uma boa opção ao projetar classes cujos construtoresou static factories tenham mais do que uns poucos parâmetros.

## 3) Implemente a propriedde de um singleton

- Um singleton é uma classe instanciada exatamente uma vez. Os singletons representa tanto um objeto sem estado que executa tarefass como uma função, ou um componente do sistema intrinsecamente único. Transformar uma classe em um singleton pode dificultar o teste de seus clientes, prque é impossível substituir um singleton por implementação simulada, a menos que ela implemente uma interface que funcione como o seu tipo
- Uma vantagem da abordagem static factory reside no fato de ela lhe proporcionar a flexibilidade para mudar de ideia se uma classe é um singleton, sem alterar sua API. O método de fabricação retorna a única instância, mas pode ser modificado para retornar, por assim dizer, uma instância separada para cada thread que a invoca

## 4) Implemente a não instanciação através de construtores privados

- Garanta a não instanciação das classes utilizando construtores privados. Pode ser util em classes utilitárias
- Como construtor explícito é privado ele é inacessível fora da classe. Podemos lançar um erro no construtor privado `AssertionError`, porém não é necessário, para oferecer proteção no caso de o construtor ser invocado acidentamente dentro da classe. 
- Com efeito colateral, essa prática também impede que a classe gere subclasses. Todos os construtores devem invocar um construtor de superclasse, explícita ou implicitamente, caso constrário, uma subclasse não teria nenhum construtor de superclasse acessível para invocar

## 5) Dê preferência à injeção de dependência para integrar recursos

- Dar mais flexibilidade de classe, fazendo a suportar diversas instâncias.
- Um padrão simples para atender esse requisito é passar o recurso no construtor ao criar uma instância nova, 
- A injeção de dependência é igualmente aplicável aos construtores, static factories e aos builders
- Em suma, não utilize um singleton ou mais classe utilitária estática para implementar uma classe que depende de um ou mais recursos subjacentes cujo comportamento afete o da classe. Em vez disso, passe os recursos ou as fábricas para o construtor (ou static factory ou builder) para criar-los.

## 6) Evite a criação de objetos desnecessários

- A criação de objetos desnecessários podem prejudicar a perfomance da aplicação
- Muitas vezes, podemos evitar a criação de objetos desnecessários usando os métodos static factory em lugar dos construtores em classes imutáveis que fornecem ambos.
- Dê preferencia aos tipos primitivos do que aos tipos primitivos empacotados, e tome cuidado com o autoboxing involutário

## 7) Elimine referências obsoletas de objetos

- Uma referência absoleta é simplesmente uma referência que nunca mais será desreferenciada outra vez
- Podemos eliminar as referências obsoletas atribuindo `null` aos objetos
- Sempre que uma classe administra a própria memória, o programador deve ficar atento com os vazamentos de memória. Sempre que um elemento é liberado, qualquer referência de objeto contida no elemento deve ser anulada
- Outra fonte comum de vazamentos de memória são os caches. Nessas circunstancias, o cache deve ser limpo, de tempos em tempos, e as entradas que não são mais usadas devem ser eliminadas
- Uma terceira fonte comum de vazamentos de memória são os listeners e outras funções de callback
- Em razão de os vazamentos de memória normalmente não se manifestarem como falhas evidentes, podem permanecer em um sistema por anos. Na maior parte dos casos, eles só são identificados devido ao resultado de uma inspeção detalhada do código ou com a ajuda de uma ferramenta de depuração conhecida como `heap profiler`. Sendo assim, é melhor aprender a antecipar problemas como esses antes que ocorram, a fim de prevenir que aconteçam

## 8) Evite o uso dos finalizadores e dos cleaners

- Os finalizadores são imprevisíveis, perigosíssimos e quase sempre desnecessários. Seu uso pode causar comportamento instável, desempenho insatisfatório e problemas de portabilidade.
- A partir do java 9, os finalizadores ficaram obsoletos, porém ainda estão sendo utilizados pelas bibliotecas Java. O Java 9 substituiu os finalizadores pelos cleaners
- Os cleaners são menos perigosos do que os finalizadores, mas ainda são imprevisíveis, lentos e geramente desnecessários
- O ponto fraco dos finalizadores e dos cleaners é que não há garantia de que serão executados pontualmente.
- Pode levar um tempo arbitrariamente longo entre o momento em que um objeto se torna inacessível e aquele em que o finalizador ou cleaner é executado. Isso significa que você nunca deve fazer nada com um finalizador ou cleaner que dependa criticamente do tempo
- Por exemplo, depender de um finalizador ou cleaner para fechar os arquivos é um erro grave, pois os descritores de arquivos abertos sõ um recurso limitado
- Para evitar o uso de um finalizador ou cleaner, podemos implementar nas classes o `AutoCloseable` exijindo dos clientes a invocação do método `close` em cada instância quando ela não form mais necessária, normalmente usando o `try-with-resources` para garantir o encerramento, mesmo diante de exceções

## 9) Prefira o uso do `try-with-resources` ao `try-finally`

- Historiacamente, uma instrução `try-finally` era a melhor maneira de garantir que um recurso fosse fechado corretamente, mesmo em casos de exceção ou retorno. Pode ser útil quando se temos apenas um recurso, porém pode se tornar inelegivel além de prejudicar a perfomance quando temos mais de um recurso
- As versões do `try-with-resources` não são apenas mais curtas e mais legíveis que as originais, como também fornecem diagnósticos bem melhores.
- A lição é clara: use sempre o `try-with-resources` em vez do `try-finally` ao trabalhar com recursos que devem ser fechados. O código resultante é mais curto e compreensível, e as exceções que ele gera são mais úteis. A instrução `try-with-resources`facilita a escrita correta do código usando recursos que devem ser fechados, o que era praticamente impossível com o `try-finally`