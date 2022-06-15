package udemy.poo;

import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        System.out.println("Enter product data");
        System.out.print("Name: ");
        product.setName(scanner.nextLine()); 
        System.out.print("Price: ");
        product.setPrice(scanner.nextDouble());
        System.out.print("Quantity in stock: ");
        product.setPrice(scanner.nextInt());

        System.out.println(product);

        System.out.print("Enter the number of products to be added in stock: ");
        int quantity = scanner.nextInt();
        product.addProduct(quantity);
        
        System.out.println(product);        

        scanner.close();
    }
}
