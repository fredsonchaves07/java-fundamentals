package udemy.chalenges;

import java.util.Scanner;

public class Factorial {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int number = scanner.nextInt();
        int factorialNumber = number;

        if(number == 0){
            System.out.println(1);
        }

        for(int i = number - 1; i > 0; i --){
            factorialNumber *= i;
        }

        System.out.println(factorialNumber);

        scanner.close();
    }
}
