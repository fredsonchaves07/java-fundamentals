package poo.udemyBank.program;

import poo.udemyBank.entities.Account;
import poo.udemyBank.entities.BusinessAccount;
import poo.udemyBank.entities.SavingsAccount;

public class Program {
    
    public static void main(String[] args) {
        
//        Scanner scanner = new Scanner(System.in);
//        Account account;
//
//        System.out.print("Enter account number: ");
//        int accountNumber = scanner.nextInt();
//        scanner.nextLine();
//        System.out.print("Enter account holder: ");
//        String accountHolder = scanner.nextLine();
//        System.out.print("Is there na initial deposit (y/n)? ");
//        char deposit = scanner.nextLine().charAt(0);
//
//        if(deposit == 'y'){
//            System.out.print("Enter initial deposit value: ");
//            double value = scanner.nextDouble();
//            account = new Account(accountNumber, accountHolder, value);
//        } else {
//            account = new Account(accountNumber, accountHolder);
//        }
//
//        System.out.println("Account data");
//        System.out.println(account);
//
//        System.out.print("Enter a deposit value: ");
//        double depositValue = scanner.nextDouble();
//        account.deposit(depositValue);
//        System.out.println("Updated account data:");
//        System.out.println(account);
//
//        System.out.print("Enter a withdraw value: ");
//        double withdrawValue = scanner.nextDouble();
//        account.withdraw(withdrawValue);
//        System.out.println("Updated account data: ");
//        System.out.println(account);
//
//        scanner.close();

        /* Upcasting */
        Account acc = new Account(1001, "Alex", 0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0, 500.0);
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 0, 0.01);
        System.out.println(acc2.getValue());

        /* DownCasting */
        BusinessAccount acc4 = (BusinessAccount) acc2;
    }
}
