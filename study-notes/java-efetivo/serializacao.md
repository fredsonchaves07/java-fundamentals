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

## Item 88: Escreva métodos `readObject` defensivamente

- O `readObject` é um construtor que recebe uma stream de bytes como único parâmetro. No uso normal, a stream de bytes é gerado serializando uma instância normalmente construída. O Problema surge quando o um objeto que viole as invariantes de sua classe
- Essa stream de bytes pode ser usada para criar um objeto impossível, que não poderia ser criado usando um construtor normal
- Quando um objeto é desserializado, é de suma importância copiar defensivamente qualquer campo que tenha uma referência de objeto que um cliente não deve ter

## Item 89: Dê preferência aos tipos enum em vez do `readResolve` para controle de instância

- Se você depender do `readResolve` para o controle de instância, todos os campos de instância com tipos de referência de objeto tem que ser declarados com `transient`
- O uso do `readResolve` para o controle de instância não é obsoleto. Se tiver que escrever uma classe serializável controlodada por instância, cujas instâncias não sejam conhecidas em tempo de compilação, você não poderá representar a classe com um tipo enum

## Item 90: Pense em usar proxies de serialização em vez de instâncias serializadas

- Existe uma técnica que reduz o risco de implementar a `Serializable` conhecida como o padrão de proxy de serialização
- O padrão de proxy de serialziação é razoavelmente simples. Primeiro, projete uma classe aninhada estática privada que represente de forma concisa o estado lógico de uma instância de classe envolvente. Essa classe aninhada é conhecida como proxy de serialização da classe envolvente
- Ela deve ter um único construtor, cujo tipo de parâmetro é a classe envolvente. Esse construtor apenas copia os dados do seu argumento
- Tal como a abordagem da cópia defensiva, esta abordagem impede o ataque fictício da stream de bytes e o ataque de roubo de campo interno