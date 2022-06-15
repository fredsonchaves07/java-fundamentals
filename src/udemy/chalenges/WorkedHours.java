package udemy.chalenges;

import java.util.Scanner;

public class WorkedHours {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int numberHours = scanner.nextInt();
        double valueHours = scanner.nextDouble();

        double salary = numberHours * valueHours;

        System.out.println("NUMBER = " + number);
        System.out.printf("SALARY = U$%.2f%n", salary);

        scanner.close();
    }
}
