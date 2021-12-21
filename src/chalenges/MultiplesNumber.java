package chalenges;

import java.util.Scanner;

public class MultiplesNumber {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int multiple = scanner.nextInt();
        int number = scanner.nextInt();

        if (number % multiple == 0 || multiple % number == 0){
            System.out.println("São multiplos");
        } else {
            System.out.println("Não são multiplos");
        }

        scanner.close();
    }
}
