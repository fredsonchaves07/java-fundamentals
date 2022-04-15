package functionalProgramming;

import java.util.ArrayList;
import java.util.List;

public class Function {

    public static void main(String[] args) {
        /*
        - A função map é uma uma função que aplica uma função a todos elementos de uma stream
        - Retorna uma stream com um conjunto de dados aplicados a partir de uma lista utilizando uma função
         */
        List<Product> products = new ArrayList<>();
        products.add(new Product("Tv", 900.0));
        products.add(new Product("Mouse", 50));
        products.add(new Product("Tablet", 350.50));
        products.add(new Product("HD Case", 80.90));
        List<String> productName = products.stream().map(product -> product.getName().toUpperCase()).toList();
        System.out.println(productName);
    }
}
