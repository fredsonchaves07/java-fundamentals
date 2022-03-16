package interfaces.model.services;

public class BazilTaxService implements TaxService{

    public double tax(double amount) {
        if (amount <= 100.0) return amount * 0.2;
        return amount * 0.15;
    }
}
