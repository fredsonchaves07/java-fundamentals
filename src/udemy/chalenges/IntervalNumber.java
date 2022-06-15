package udemy.chalenges;

import java.util.Scanner;

public class IntervalNumber {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        String interval;

        if(number  >= 0 && number <= 25){
            interval = "(0, 25)";
        } else if (number  >= 0 && number <= 50){
            interval = "(25, 50)";
        } else if (number  >= 0 && number <= 75){
            interval = "(50, 75)";
        } else if (number  >= 0 && number <= 100){
            interval = "(75, 100)";
        } else {
            interval = "Fora do intervalo";
        }

        System.out.println("Intervalo: " + interval);

        scanner.close();
    }
}
