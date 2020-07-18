package TaxCalculator.Products;

public class Fragrance extends Product {

    private Fragrance(double price, String description) {
        super(price, description);
    }

    public static Fragrance getInstance(double price, String description) {
        return new Fragrance(price, description);
    }

    public static Fragrance getInstance(double price) {
        return new Fragrance(price, "fragrance");
    }
}
