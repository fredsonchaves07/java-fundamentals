# Métodos

## Item 49: Verifique a validade dos parâmetros

- A maioria dos métodos e construtores apresentam restrições no que diz respeito aos valores que podem ser passados dentro de sus parâmetros
- Você deve documentar claramente todas eas restrições e as implementar com as verificações no início do método. Isso faz parte do princípio geral de que você deve tentar detectar os erros assim que possível, logo que ocorrerem
- Para métodos públicos e protegidos use a tag javadoc `@throws` para documentar a exceção que será lançada caso uma restrição dos valores do parâmetro seja violada
- O método `Objects.requireNonNul`, é flexível e prático, portanto, não há nenhuma razão para executar verificações de nulidade manualmente. Caso queira, você pode especificar a própria mensagem detalhada das exceções. O método retorna sua entrada, assim você pode executar a verificação de nulidade ao mesmo tempo em que usa um valor
- Métodos não públicos também podem realziar a checagem dos parâmetros com a utilização dos assertions

## Item 50: Faça cópias defensivas quando necessário

- Você deve programar defensivamente, partindo do príncipio que os clientes de sua classe farão o melhor para destruir as invariantes dela.
- À medida que as pessoas tentam a todo custo burlar a segurança dos sistemas, todavia o mais frequente será sua classe ter que ldiar com o comportamento inesperado oriundo dos erros de otrus programadores
- É fundamental fazer uma copia defensiva de cada parâmetro mutável para seu construtor e usas as cópias como os componentes da instância em vez das originais
- Não use o método `clone` para fazer uma cópia defensiva de um parâmetro cujo tipo possa ser subclasseado por terceiros não confiáveis

## Item 51: Projete as assinaturas de método com cuidado

- Escolha os nomes do método com muito cuidado. Os nomes sempre devem obedecer às convenções padrões de nomeclatura. Seu primeiroobjetivo deve escolher nomes compreensíveis e consistentes com os outros no mesmo pacote. Seu segundo objetivo deve ser escolher nomes coerentes com o consenso geral, onde existrir
- Evite nomes longos para os métodos
- É recomendável utilizar no máximo 4 parâmetros no método
- Para os tipos de parâmetros, dê preferência às interfaces em vez das classes
- Dê preferência aos tipos enum de dois elementos em vez dos parâmetros boolean