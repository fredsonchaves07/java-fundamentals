package chalenges;

import java.util.Scanner;

public class Geometry {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        double valueA = scanner.nextDouble();
        double valueB = scanner.nextDouble();
        double valueC = scanner.nextDouble();

        System.out.printf("TRIANGULO: %.3f%n", valueA * valueC);
        System.out.printf("CIRCULO: %.3f%n", valueC * Math.PI);
        System.out.printf("TRAPEZIO: %.3f%n",valueA * valueB * valueC);
        System.out.printf("QUADRADO: %.3f%n", valueB * 2);
        System.out.printf("RETANGULO: %.3f%n", valueA * valueB);

        scanner.close();
    }
}
