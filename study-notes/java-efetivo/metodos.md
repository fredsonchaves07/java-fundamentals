# M�todos

## Item 49: Verifique a validade dos par�metros

- A maioria dos m�todos e construtores apresentam restri��es no que diz respeito aos valores que podem ser passados dentro de sus par�metros
- Voc� deve documentar claramente todas eas restri��es e as implementar com as verifica��es no in�cio do m�todo. Isso faz parte do princ�pio geral de que voc� deve tentar detectar os erros assim que poss�vel, logo que ocorrerem
- Para m�todos p�blicos e protegidos use a tag javadoc `@throws` para documentar a exce��o que ser� lan�ada caso uma restri��o dos valores do par�metro seja violada
- O m�todo `Objects.requireNonNul`, � flex�vel e pr�tico, portanto, n�o h� nenhuma raz�o para executar verifica��es de nulidade manualmente. Caso queira, voc� pode especificar a pr�pria mensagem detalhada das exce��es. O m�todo retorna sua entrada, assim voc� pode executar a verifica��o de nulidade ao mesmo tempo em que usa um valor
- M�todos n�o p�blicos tamb�m podem realziar a checagem dos par�metros com a utiliza��o dos assertions

## Item 50: Fa�a c�pias defensivas quando necess�rio

- Voc� deve programar defensivamente, partindo do pr�ncipio que os clientes de sua classe far�o o melhor para destruir as invariantes dela.
- � medida que as pessoas tentam a todo custo burlar a seguran�a dos sistemas, todavia o mais frequente ser� sua classe ter que ldiar com o comportamento inesperado oriundo dos erros de otrus programadores
- � fundamental fazer uma copia defensiva de cada par�metro mut�vel para seu construtor e usas as c�pias como os componentes da inst�ncia em vez das originais
- N�o use o m�todo `clone` para fazer uma c�pia defensiva de um par�metro cujo tipo possa ser subclasseado por terceiros n�o confi�veis

## Item 51: Projete as assinaturas de m�todo com cuidado

- Escolha os nomes do m�todo com muito cuidado. Os nomes sempre devem obedecer �s conven��es padr�es de nomeclatura. Seu primeiroobjetivo deve escolher nomes compreens�veis e consistentes com os outros no mesmo pacote. Seu segundo objetivo deve ser escolher nomes coerentes com o consenso geral, onde existrir
- Evite nomes longos para os m�todos
- � recomend�vel utilizar no m�ximo 4 par�metros no m�todo
- Para os tipos de par�metros, d� prefer�ncia �s interfaces em vez das classes
- D� prefer�ncia aos tipos enum de dois elementos em vez dos par�metros boolean