package udemy.chalenges;

import java.util.Scanner;

public class CordXY {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        while(x != 0 && y != 0){
            if(x > 0 && y > 0){
                System.out.println("Primeiro");
            } else if (x > 0 && y < 0){
                System.out.println("Quarto");
            } else if (x < 0 && y > 0){
                System.out.println("Segundo");
            } else {
                System.out.println("Terceiro");
            }

            x = scanner.nextInt();
            y = scanner.nextInt();
        }

        scanner.close();
    }
}
