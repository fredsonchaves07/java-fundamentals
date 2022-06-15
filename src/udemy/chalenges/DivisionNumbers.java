package udemy.chalenges;

import java.util.Scanner;

public class DivisionNumbers {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int countNumber = scanner.nextInt();

        for(int i = 0; i < countNumber; i ++){
            int firstNumber = scanner.nextInt();
            int secondNumber = scanner.nextInt();

            if(secondNumber == 0){
                System.out.println("Divisão impossível");
            } else {
                System.out.println(firstNumber / secondNumber);
            }
        }

        scanner.close();
    }
}
