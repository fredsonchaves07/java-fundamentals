package udemy.poo.udemyBank.entities;

public final class SavingsAccount extends Account {

    private Double interestRate;

    public SavingsAccount(int accountNumber, String accountHolder, double value, Double interestRate) {
        super(accountNumber, accountHolder, value);
        this.interestRate = interestRate;
    }

    public SavingsAccount(int accountNumber, String accountHolder, Double interestRate) {
        super(accountNumber, accountHolder);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        value += value * interestRate;
    }

    @Override
    public double withdraw(double value) {
        return this.value -= value;
    }
}
