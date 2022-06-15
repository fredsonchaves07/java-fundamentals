package udemy.functionalProgramming;

import java.util.ArrayList;
import java.util.List;

public class Predicate {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Tv", 900.0));
        products.add(new Product("Mouse", 50));
        products.add(new Product("Tablet", 350.50));
        products.add(new Product("HD Case", 80.90));
        /* Primeira forma de utilização de predicate (mais usual)
        products.removeIf(product -> product.getPrice() >= 100);
         */
        /* Segunda forma de utilização */
        products.removeIf(new ProductPredicate());
        System.out.println(products);
    }
}
