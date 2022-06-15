package udemy.functionalProgramming;

import java.util.ArrayList;
import java.util.List;

public class Consumer {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Tv", 900.0));
        products.add(new Product("Mouse", 50));
        products.add(new Product("Tablet", 350.50));
        products.add(new Product("HD Case", 80.90));
        products.forEach(product -> product.setPrice(product.getPrice() * 1.1));
        System.out.println(products);
    }
}
