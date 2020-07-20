package TaxCalculator.Products;

public class Book extends Product {

    private Book(double price, String description) {
        super(price, description);
    }

    public static Book getInstance(double price, String description) {
        return new Book(price, description);
    }

    public static Book getInstance(double price) {
        return new Book(price, "book");
    }
}