package features.java17.textBlock;

public class Main {

    public static void main(String[] args) {
        String query = """
                    SELECT 
                        products.id,
                        products.name,
                        products.category
                    FROM products
                    WHERE products.id = 1
                    ORDER BY products.name;
                """;
        System.out.println(query);
    }
}
