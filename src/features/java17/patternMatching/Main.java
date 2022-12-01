package features.java17.patternMatching;

import java.time.DayOfWeek;

public class Main {

    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.MONDAY; // Assign here the value
        System.out.println(switch (day) {
            case SUNDAY, SATURDAY -> "Weekend";
            case FRIDAY, THURSDAY, WEDNESDAY, TUESDAY, MONDAY -> "Weekday";
        });
    }
}
