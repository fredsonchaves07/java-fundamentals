package poo.udemyBank;

import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Account account;

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter account holder: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Is there na initial deposit (y/n)? ");
        char deposit = scanner.nextLine().charAt(0);

        if(deposit == 'y'){
            System.out.print("Enter initial deposit value: ");
            double value = scanner.nextDouble();
            account = new Account(accountNumber, accountHolder, value);
        } else {
            account = new Account(accountNumber, accountHolder);
        }

        System.out.println("Account data");
        System.out.println(account);

        System.out.print("Enter a deposit value: ");
        double depositValue = scanner.nextDouble();
        account.deposit(depositValue);
        System.out.println("Updated account data:");
        System.out.println(account);

        System.out.print("Enter a withdraw value: ");
        double withdrawValue = scanner.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println("Updated account data: ");
        System.out.println(account);

        scanner.close();
    }
}
