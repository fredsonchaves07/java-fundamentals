package udemy.enums;

import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order);
        OrderStatus orderStatus = OrderStatus.valueOf("DELIVERED");
        System.out.println(orderStatus);
    }
}
