package udemy.chalenges;

import java.util.Scanner;

public class PasswordValid {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int password = scanner.nextInt();

        while(password != 2002){
            System.out.println("Senha inválida");
            password = scanner.nextInt();
        }

        System.out.println("Acesso Permitido");

        scanner.close();
    }
}
