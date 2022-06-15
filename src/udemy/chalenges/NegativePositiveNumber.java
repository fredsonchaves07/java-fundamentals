package udemy.chalenges;

import java.util.Scanner;

public class NegativePositiveNumber {
    
    public static void main(String[] args) {
        
        Scanner scaneer = new Scanner(System.in);
        int number = scaneer.nextInt();

        if (number > 0){
            System.out.println("POSITIVO");
        } else {
            System.out.println("NEGATIVO");
        }

        scaneer.close();
    }
}
