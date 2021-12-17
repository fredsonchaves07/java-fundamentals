package chalenges;

import java.util.Scanner;

public class AreaCircle {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double raio = scanner.nextDouble();
        double area = Math.PI * Math.pow(raio, 2);

        System.out.printf("A=%.4f%n", area);

        scanner.close();
    }
}
