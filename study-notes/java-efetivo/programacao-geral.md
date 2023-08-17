# Programa��o geral

## Item 57: Minimize o escopo das vari�veis locais

- Ao minimizar o escopo das vari�veis locais, voc� aumenta a legibilidade e a facilidade de manuten��o do seu c�digo e reduz as probabilidades de erro
- A t�cnica mais poderosa para minimizar o escopo de uma vari�vel local � declar�-la onde ela ser� utilizada pela primeira vez
- Uma �ltima t�cnica para minimizar o escopo das vari�veis locais � manter os m�todos pequenos e focados. Se combinar duas atividades no mesmo m�todo, as vari�veis locais relevantes para uma atividade podem estar no escopo do c�digo que executa a outra atividade. Para evitar que isso aconte�a, basta dividir o m�todo em dois: um para cada atividade

## Item 58: D� prefer�ncia aos loops for-each em vez dos tradicionais loops for

- Os loops for each s�o mais perfom�ticos e simples de fazer manuten��o
- Caso voc� esteja escrevendo um tipo que representa um grupo de elementos, voc� deve seriamente pensar em implementar a `Iterable`, mesmo que escolha n�o implementar a `Collection`. Isso permitir� que seus usu�rios fa�am uma itera��o sobre seu tipo usando o for-each

## Item 59: Conhe�a e utilize as bibliotecas

- Ao usar uma biblioteca padr�o, voc� usufrui do conhecimento dos especialistas que escreveram e da experi�ncia daqueles que a utilizaram antes de voc�
- Adicionam-se numerosas funcionalidades �s bibliotecas a cada vers�o, e vale a pena estar a par destas edi��es

## Item 60: Evite o `float` e `double` caso sejam necess�rias respostas exatas

- Os tipos `float` e `double` s�o particularmente inadequados para c�lculos monet�rios, dado que � imposs�vel representar exatamente 0,1 (ou qualquer outra pot�ncia negativa de dez) como um `float` ou um `double`
- Use a `BigDecimal`, o `int` ou `long` para c�lculos monet�rios

## Item 61: D� prefer�ncia aos tipos primitivos em vez dos tipos primitivos empacotados

- Utilize os tipos primitivos em vez dos primitivos empacotados sempre que voc� tiver a chance
- Os tipos primitivos s�o mais simples e mais r�pidos
- O autoboxing reduz a verbosidade, mas n�o o periodo de se usar os primitivos empacotados
- Quando o seu programa realiza c�lculos de tipos misturados que envolvem primitivos empacotados e desempacotados, ele exructa o procedimento de unboxing, e quando o seu programa faz o unboxing, ele pode la�r uma `NullPointerException`

## Item 62: Evite as strings onde outros tipos forem mais adequados

- De um modo geral, se houver um tipo de valor apropriado, seja ele primitivo ou uma refer�ncia de objeto, voc� deve us�-lo; se n�o houve, voc� deve escrever um
- Usadas de forma inadequada, as strings s�o mais pesadas, menos male�veis, mais lentas e mais propensas a erros do que os outros tipos. As Strings s�o comumente mal usada para represenar tipos primitivos, enums e tipos agregados