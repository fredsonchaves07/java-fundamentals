package udemy.specialTopics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateJava {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date date1 = simpleDateFormat.parse("25/06/2018");
        Date date2 = simpleDateFormat2.parse("25/06/2018 15:45:07");

        System.out.println(simpleDateFormat.format(date1));
        System.out.println(date2);
    }
}
