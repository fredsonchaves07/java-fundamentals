package interfaces.model.services;

import interfaces.model.entities.CarRental;
import interfaces.model.entities.Invoice;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;
    private TaxService taxService;

    public RentalService() {}

    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        long instantStart = carRental.getStart().getTime();
        long instantFinish = carRental.getFinish().getTime();
        double hours = (double) (instantFinish - instantStart) / 1000 / 60 / 60;
        double basicPayment;
        if (hours <= 12) {
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(hours / 24) * pricePerDay;
        }
        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
