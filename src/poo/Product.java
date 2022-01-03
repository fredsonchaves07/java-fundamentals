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

    @Override
    public String toString(){
        return "Product: " + this.name + " price R$ " + this.price + " quantity " + this.quantity;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        System.out.println("Enter product data");
        System.out.print("Name: ");
        product.name = scanner.nextLine();
        System.out.print("Price: ");
        product.price = scanner.nextDouble();
        System.out.print("Quantity in stock: ");
        product.quantity = scanner.nextInt();

        System.out.println(product);

        System.out.print("Enter the number of products to be added in stock: ");
        int quantity = scanner.nextInt();
        product.addProduct(quantity);
        
        System.out.println(product);        

        scanner.close();
    }
}
