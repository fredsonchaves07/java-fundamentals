package features.java17.records;

public record Product(String name, Integer price) {

    public Product(String name) {
        this(name, 10);
    }

    public Product(Integer price) {
        this("", price);
    }
}
