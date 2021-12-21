package chalenges;

import java.util.Scanner;

public class ProductValue {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int codProduct1 = scanner.nextInt();
        int numberProduct1 = scanner.nextInt();
        double valueProduct1 = scanner.nextDouble();

        int codProduct2 = scanner.nextInt();
        int numberProduct2 = scanner.nextInt();
        double valueProduct2 = scanner.nextDouble();

        double total = (valueProduct1 * numberProduct1) + (valueProduct2 * numberProduct2);

        System.out.printf("Valor a pagar: R$%.2f%n", total);

        scanner.close();
    }
}
