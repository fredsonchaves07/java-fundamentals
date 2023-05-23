package algaworks.datetime.instant;

import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        Instant instant = Instant.now();

        //Convertendo de Instant para Date.
//        Date date = Date.from(instant);
//        System.out.println(instant);
//        System.out.println(date);

        //Convertendo Date para Instant
        Date date = new Date();
        Instant instant = date.toInstant();
    }
}
