package poo.udemyBank;

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
        if (amount <= loanLimit) accountNumber += amount - 10;
    }
}
