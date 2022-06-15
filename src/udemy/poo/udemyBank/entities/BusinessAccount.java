package udemy.poo.udemyBank.entities;

public class BusinessAccount extends Account {

    private Double loanLimit;

    public BusinessAccount(int accountNumber, String accountHolder, double value, Double loanLimit) {
        super(accountNumber, accountHolder, value);
        this.loanLimit = loanLimit;
    }

    public BusinessAccount(int accountNumber, String accountHolder, Double loanLimit) {
        super(accountNumber, accountHolder);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount) {
        if (amount <= loanLimit) value += amount - 10;
    }

    @Override
    public double withdraw(double value) {
        super.withdraw(value);
        return this.value -= 2.0;
    }
}
