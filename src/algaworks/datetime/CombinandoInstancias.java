package algaworks.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CombinandoInstancias {

    public static void main(String[] args) {
        LocalDate data = LocalDate.of(1995, 1, 29);
        LocalTime hora = LocalTime.of(10, 6, 3);
        LocalDateTime dataHora = LocalDateTime.of(data, hora);
        System.out.println(dataHora);
    }
}
