package udemy.otherTopics;

import java.util.Scanner;

public class BitWise {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int mask = 32;
        int number = scanner.nextInt();

        if((mask ^ number) == 1){
            System.out.println("6th bitwise");
        } else {
            System.out.println("6th not bitwise");
        }

        scanner.close();
    }
}
