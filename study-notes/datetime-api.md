# Api de data e hora do Java

- A partir da versão 8, o Java introduziu novas versões de data e hora
- Api mais robusta e com funcionalidades interessantes que substitui a antiga
- Implementa o padrão ISO-9001

## `Instant`

- Classe que representa o instante do tempo desde 1º de janeiro de 1970 do UTC

```java
public class Main {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
    }
}
```

- Esta classe deve ser usada quando queremos representar algum instante da linha do tempo

### Conversão de `Date` para `Instant` ou vice versa

- Convertendo `Instant` para `Date`

```java
Date date = Date.from(instant);
```

- Convertendo `Date` para `Instant`

```java
Instant instant = date.toInstant();
```

## `LocalDate`

- Representa apenas a informação de data sem hora e minutos
- Pelo fato de não ter a hora não representa o instante exato
- É usado quando queremos apenas a informação da data

```java
public static void main(String[] args) {
    LocalDate date = LocalDate.now();
    System.out.println(date);
}
```