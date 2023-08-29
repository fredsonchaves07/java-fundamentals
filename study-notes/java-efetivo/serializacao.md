# Serialização

## Item 85: Prefira alternativas à serialização Java

- A desserialização do Java é um perigo evidente e presente, pois é amplamente utilizada diretamente por aplicações e indiretamente por subsistemas Java, como o RMI, JMX e o JMS
- A desserialização de streams não confiáveis ocasiona a execução remota do código (RCE), a negação de serviço (DoS) e uma série de outros exploits. As aplicações são vulneráveis a esses ataques mesmo que não tenham feito nada de errado
- A melhor maneira de se evitarem os exploits de serialização é nunca realizar a desserialização em nada
- Não há motivos para usar a serialização Java em qualquer sistema novo que você escreva. Há outros mecanismos para tradução entre objetos e sequências de bytes que evitam muitos dos perigos de serialização Java, oferecendo inúmeras vantagens, como suporte a várias plataformas, alto desempenho, um ecossistema enorme de ferramentas e uma comunidade vasta de especialistas
- As principais representações de dados estruturados entre plataformas são o Json e o Protocol Buffers, também conhecido como protobuf
- Infelizmente, a serialização ainda domina o ecosistema Java. Se você está fazendo manutenção de um sistema baseado em serialização Java, considere seriamente a migração para uma representação de dados estruturas entre plataformas, mesmo que isso exiga um grande esforço

## Item 86: Tenha cautela ao implementar a `Serializable`

- O maior custo da implementação da `Serializable` é que ela diminui a flexibilidade de alterar a implementação de uma classe uma vez que seja liberada
- O segundo custo de implementação da `Serializable` é que ela aumenta a probabilidade de bugs e brechas de segurança. Normalmente, os objetos são criados com os construtores; a serialização é um mecanismo extra linguístico para criar objetos. Mesmo se você aceeitar o comportamento padrão ou o sobrescrever, a desserialização é um construtor oculto com todos os mesmos problemas que outros construtores
- O terceiro custo da implementação da `Serializable` é que ela potencializa a carga de testes associada à liberação da versão nova de uma classe

## Item 87: Pense na possibilidade de usar uma forma serializada customizada

- Não aceite a forma serializada padrão sem, primeiro, considerar se é apropriada ou não. Aceitar a forma serializa padrão deve ser uma decisão consciente de que essa codificação é aceitável do ponto de vista da flexibilidade, do desempenho e da correção.
- Seja qual for a forma serializada que escolher, declare um serial version UID explicito em cada classe serializável que você escreva
- Se você decidiu que uma classe deve ser serializavel, pense muito a respeito de como a forma serializada deve ser. Use a forma padrão serializada somente se ela for uma descrição aceitável do estado lógico do objeto; caso contrário, projete uma forma serializada customizada que descreva adequadamente o objeto