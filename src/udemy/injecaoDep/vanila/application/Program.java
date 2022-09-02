package udemy.injecaoDep.vanila.application;

import udemy.injecaoDep.vanila.services.DeliverService;
import udemy.injecaoDep.vanila.services.PayService;
import udemy.injecaoDep.vanila.services.TaxService;

public class Program {

    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        DeliverService deliverService = new DeliverService();
        PayService payService = new PayService(taxService, deliverService);
        System.out.println("Resultado = " + payService.finalPrice(300, "Sp"));
    }
}
