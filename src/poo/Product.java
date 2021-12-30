package poo;

import java.util.Scanner;

public class Product {
    
    public String name;
    public double price;
    public int quantity;

    public double totalValueInStock(){
        return this.price * this.quantity;
    }

    public void addProduct(int quantity){
        this.quantity += quantity;
    }

    public void removeProduct(int quantity){
        this.quantity -= quantity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        System.out.println("Enter product data");
        System.out.println("Name: ");
        product.name = scanner.nextLine();
        System.out.println("Price: ");
        product.price = scanner.nextDouble();
        System.out.println("Quantity in stock: ");
        product.quantity = scanner.nextInt();

        System.out.println("Product: " + product.name + " price R$ " + product.price + " quantity " + product.quantity);

        scanner.close();
    }
}
