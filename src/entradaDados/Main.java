package entradaDados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String x;
        System.out.print("Digite o valor de x: ");
        x = scanner.next();

        System.out.print("Você digitou o valor: " + x);

        scanner.close();
    }
}
