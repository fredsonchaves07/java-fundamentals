package udemy.injecaoDep.vanila.services;

public class DeliverService {

    public double fee(String state) {
        if (state.equalsIgnoreCase("SP")) return 10.0;
        return 20;
    }
}
