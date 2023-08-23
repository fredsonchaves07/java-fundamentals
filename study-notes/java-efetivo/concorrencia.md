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