package udemy.poo;

public class Product {
    
    private String name;
    private double price;
    private int quantity;

    /* Construtor padrão */
    public Product() {

    }

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public double totalValueInStock() {
        return this.price * this.quantity;
    }

    public void addProduct(int quantity) {
        this.quantity += quantity;
    }

    public void removeProduct(int quantity) {
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "Product: " + this.name + " price R$ " + this.price + " quantity " + this.totalValueInStock();
    }

}
