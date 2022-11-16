package features.java17.records;

public class Main {

    public static void main(String[] args) {

        Product product = new Product("produto", 100);
        System.out.println(product);
        System.out.println(product.name());
        System.out.println(product.price());
    }
}
