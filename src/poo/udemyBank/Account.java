package poo.udemyBank;

public class Account {
    
    private int accountNumber;
    private String accountHolder;
    private double value;

    public Account(int accountNumber, String accountHolder, double value) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.value = value;
    }

    public Account(int accountNumber, String accountHolder){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getValue() {
        return value;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void deposit(double value){
        this.value += value;
    }

    public double withdraw(double value){
        this.value -= (value + 5);
        return value;
    }

    @Override
    public String toString() {
        return "Account " + this.accountNumber + ", Holder: " + this.getAccountHolder() + ", Balance: $ " + this.value;
    }
}
