# Concorrência

## Item 78: Sincronize o acesso aos dados mutáveis compartilhados

- Embora a especificação da linguagem garanta que uma thread não verá um valor arbitrário ao ler um campo, não garante que um valor escrito por uma thread será vísivel por outra
- A sincronização é necessária para a comunicação confiável entre as threads, bem como para a exclusão mutua. Essa situação se deve a uma parte da especificação da linguagem conhecida como modelo de memória, que especifica quando e como as alterações feitas por uma thread se tornam visíveis para as outras
- As consequências de não sincronizar o acesso aos dados mutáveis compartilhados podem ser terríveis, mesmo se os dados forem atomicamente legíveis e graváveis
- A melhor maneira de evitar os problemas discutidos nesse item é não compartilhar dados mutáveis. Compartilhe dados imutáveis ou não compartilhe nada
- Confine os dados mutáveis em uma única thread

## Item 79: Evite a sincronização excessiva

- Dependendo da situação, a sincronização excessva pode provocar a redução do desempenho, conflito ou mesmo compartamento não determinístico
- Para evitar falhas de liveness e de segurança, nunca ceda o controle ao cliente dentro de um método ou bloco sincronizado
- Trabalhe o mínimo possível nas regiões sincronizadas. Ao projetar uma classe mutável, pense se ela deve fazer a própria sincronização. Em uma era de múltiplos núcleos, é mais importante do que nunca não abusar da sincronização

## Item 80: Dê preferência aos executores, às tarefas e às streams em vez das threads

- Você pode fazer muito mais coisas com um serviço executor. Por exemplo, esperar que uma determinada tarefa seja concluida, esperar que alguma ou todas as tarefas de uma coleção sejam concluidas, esperar a finalização do serviço executor, recuperar os resultados das tarefas um após outro, à medida que são concluidas, pode agendar tarefas pra executarem um horário específico ou periodicamente e assim por diante

## Item 81: Prefira os utilitários de concorrênciaao `wait` e ao `notify`

- Desde o java 5, a plataforma vem disponibilizando utilitários de concorrência de alto nível, que fazem tipos de coisas que você outrora tinha que codificar manualmente em cima do `wait` e do `notify`
- Dada a dificuldade de usar o `wait` e `notify` corretamente, você deve usar os utilitários de concorrência de nível superior
- Por exemplo, use a `ConcurrentHashMap` em vez da `Collections.synchronizedMap`. Substituir maps sincronizados por maps concorrentespode aumentar e muito o desempenho das aplicações concorrentes

## Item 82: Documente a thread safety

- A presença do modificador `synchronized` em uma declaração de método é um detalhe de implementação, não parte de sua API
- Para possibilitar o uso concorrente seguro, uma classe deve documentar com clareza o nível de thread safety que suporta
- Documentar uma classe condicionalmente thread-safe requer cuidado. Você deve indicar quais sequências de invocação exigem sincronização externa e qual bloqueio (ou, em casos raros, bloqueios) deve ser utilizado para executar essas sequências. Normalmente, é o bloqueio na própria instãncia, mas há exceções
- Toda classe deve documentar claramente suas propriedades de thread safety com uma descrição de texto redigida com muito cuidado ou com uma notação de thready safety.
- Classes condiciona++lmente thread-safe devem documentar quais sequências de invocação do método exigem uma sincronização externa e quais bloqueios devem ser adquiridos ao executar essas sequências

## Item 83: Utilize a inicialização preguiçosa com parcimônia

- A inicialização preguiçosa é o ato de atrasar a inicialização de um campo ate que seu valor seja necessário. Se o valor nunca for necessário, o campo nunca será inicializado
- Essa técnica se aplica aos campos estáticos e aos de instância. Enquanto a inicialização preguiçosa é basicamente uma otimicação, também pode ser usada para romper as circularidades prejudiciais na inicialização de classes e instâncias

## Item 84: Não dependa do agendador de threads

- Quando muitas threads são executáveis, o agendador de threads determina quais devem ser executadas e por quanto tempo. Qualquer sistema operacional normal tentará fazer essa determinação de forma imparcial, mas a política pode variar
- Programas bem escritos não devem depender dos detalhes dessa política
- Não dependa do agendador de threads para a correção de seu programa. O programa resultante não será robusto nem portátil.
- As propriedades da thread podem ser usadas com parcimônia para melhorar a qualidade do serviço de um programa já em funcionamento, mas nunca devem ser utilizadas para "corrigir" um programa que mal funciona