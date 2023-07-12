# Boas práticas utilizando Java Efetivo

## Criar e destruir objetos

### 1) Considere os métodos static factory em vez de construtores

- Alternativa ao modo tradicional de instanciar uma classe. Podemos fornecer um método static factory publico que retorna uma instância de uma classe
- Uma das vantagens dos métodos static factory é que, ao contrário dos construtores, eles tem nômes. Ou seja, é mais fácil de lê e entender o fluxo do código
- A segunda vantagem dos métodos static factory é que, ao contrário dos construtores, não precisam criar um novo objeto sempre que invocados. Essa abordagem é semelhante ao padrão Flyweigh. Ela melhora significativamente o desempenho caso os objetos equivalentes sejam requisitados com frequẽncia, principalmente se a criação deles for custosa
- A terceira vantagem é que, ao contrário dos construtores, podem retonar um objeto de qualquer subtipo do próprio tipo de retorno.
- A quarta vantagem é que a classe do objeto retornado pode variar de chamada para chamada, em função dos parâmetros de entrada. Um exemplo de classe que utiliza essa abordagem é a `EnumSet`
- A quinta vantagem dis static factories é que não precisa existir a classe do objeto retornado quando a classe contém o método de escrita. Muito utilizado em frameworks de injeção de dependencia
- A principal limitação de fornecer apenas métodos static factory é que as classes sem construtores públicos ou protegidos não podem ser divididas em sublcasses.
- Outra principal limitação é que esses métodos são dificeis de ser encontrados pelo programadores
- Em suma, tanto os métodos static factory como os construtores públicos têm seus usos, e vale a pena compreender seus respectivos pontos positivos. Não raro, recomenda-se o uso dos métodos static factoy, assim, evita-se os impulso de empregar construtores públicos sem antes levar em consideraração as static factories

### 2) Cogite o uso de um builder quando se deparar com muitos parâmetros no construtor

- Para resolver esta questão, tradicionalmente, os programadores têm usado o padrão `telescoping constructor`, no qual você fornece um construtor somente com os parâmetros necessários, outro com um único parâmetro opcional, um terceiro com dois e assim sucessivamente. O padrão telescoping constructor funciona, mas é difícil escrever código do cliente quando se tem muitos parâmetros, e é ainda mais difícil de ler.
- Uma alternativa eficiente seria utilizar o padrão `Builder`. Em vez de construir diretamente o objeto pretendido, o cliente chama um construtor (ou uma static factory) com todos os parâmetros necessários e obtém um objeto builder, Em seguida, o cliente chama o método do tipo setter no objeto builder para definir cada parâmetro opcional de interesse. Por fim, o cliente chama um método builder sem parâmetros para gerar o objeto, nomalmente imultavel. Em geral, o builder é um membro de classe estática
- O padrão Builder simula os parâmetros opcionais nomeados como os que encontramos nas linguagens Python e Scala.
- O padrão Builder também apresenta desvantagens. Para criar um objeto, você deve primeiro criar um builder. Embora seja pouco provável que o custo de criação desse builder seja considerável na prática, isso pode ser um problema em situações críticas de desempenho. Além disso, o padrão Builder é mais verboso do que o padrão do telescoping constructor, logo, ele deve ser usado apenas se houver parâmetros suficientes que justifiquem seu uso, digamos que quatro parâmetros ou mais.
- Em síntese, o padrão Builder é uma boa opção ao projetar classes cujos construtoresou static factories tenham mais do que uns poucos parâmetros.

### 3) Implemente a propriedde de um singleton
