package udemy.injecaoDep.vanila.services;

public class PayService {

    private TaxService taxService;

    private DeliverService deliverService;

    public PayService(TaxService taxService, DeliverService deliverService) {
        this.taxService = taxService;
        this.deliverService = deliverService;
    }

    public double finalPrice(double cost, String state) {
        return cost + deliverService.fee(state) + taxService.tax(cost);
    }
}
