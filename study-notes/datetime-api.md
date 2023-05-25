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

## `LocalTime`

- Representa apenas a informação do tempo (horário) sem data ou timezone
- É usado quando queremos apenas a informação do horário

```java
public static void main(String[] args) {
    LocalTime horario = LocalTime.now();
    System.out.println(horario);
}
```

## `LocalDateTime`

- Representa a data e o horário sem a informação de timezone
- Combinação das classes `LocalDate` e `LocalTime`
- É usado quando queremos ter a informação de data e hora sem timezone

```java
public static void main(String[] args) {
    LocalDateTime dataHora = LocalDateTime.now();
    System.out.println(dataHora);
}
```

## Outras formas de  obter instâncias de `LocalDate`, `LocalTime` e `LocalDateTime`

```java
LocalDate data = LocalDate.of(1995, 1, 29);
LocalTime hora = LocalTime.of(10, 6, 3);
LocalDateTime dataHora = LocalDateTime.of(data, hora);
```