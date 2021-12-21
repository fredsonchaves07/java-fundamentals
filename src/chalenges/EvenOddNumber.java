package chalenges;

import java.util.Scanner;

public class EvenOddNumber {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number % 2 == 0){
            System.out.println("PAR");
        } else {
            System.out.println("IMPAR");
        }

        scanner.close();
    }
}
