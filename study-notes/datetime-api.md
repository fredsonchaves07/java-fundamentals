# Api de data e hora do Java

- A partir da vers�o 8, o Java introduziu novas vers�es de data e hora
- Api mais robusta e com funcionalidades interessantes que substitui a antiga
- Implementa o padr�o ISO-9001

## `Instant`

- Classe que representa o instante do tempo desde 1� de janeiro de 1970 do UTC

```java
public class Main {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
    }
}
```

- Esta classe deve ser usada quando queremos representar algum instante da linha do tempo

### Convers�o de `Date` para `Instant` ou vice versa

- Convertendo `Instant` para `Date`

```java
Date date = Date.from(instant);
```

- Convertendo `Date` para `Instant`

```java
Instant instant = date.toInstant();
```

## `LocalDate`

- Representa apenas a informa��o de data sem hora e minutos
- Pelo fato de n�o ter a hora n�o representa o instante exato
- � usado quando queremos apenas a informa��o da data

```java
public static void main(String[] args) {
    LocalDate date = LocalDate.now();
    System.out.println(date);
}
```

## `LocalTime`

- Representa apenas a informa��o do tempo (hor�rio) sem data ou timezone
- � usado quando queremos apenas a informa��o do hor�rio

```java
public static void main(String[] args) {
    LocalTime horario = LocalTime.now();
    System.out.println(horario);
}
```

## `LocalDateTime`

- Representa a data e o hor�rio sem a informa��o de timezone
- Combina��o das classes `LocalDate` e `LocalTime`
- � usado quando queremos ter a informa��o de data e hora sem timezone

```java
public static void main(String[] args) {
    LocalDateTime dataHora = LocalDateTime.now();
    System.out.println(dataHora);
}
```

## Outras formas de  obter inst�ncias de `LocalDate`, `LocalTime` e `LocalDateTime`

```java
LocalDate data = LocalDate.of(1995, 1, 29);
LocalTime hora = LocalTime.of(10, 6, 3);
LocalDateTime dataHora = LocalDateTime.of(data, hora);
```