package chalenges;

import java.util.Scanner;

public class TotalProduct {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int codProduct = scanner.nextInt();
        int quantProduct = scanner.nextInt();
        double valueProduct = 0;

        switch(codProduct){
            case 1:
                valueProduct = 4.0;
                break;
            case 2:
                valueProduct = 4.5;
                break;
            case 3:
                valueProduct = 5.0;
                break;
            case 4:
                valueProduct = 2.0;
                break;
            case 5:
                valueProduct = 1.5;
                break;
        }

        System.out.println("Total: R$" + valueProduct * quantProduct);

        scanner.close();
    }
}
