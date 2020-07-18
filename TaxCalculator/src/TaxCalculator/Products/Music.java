package TaxCalculator.Products;

public class Music extends Product {

    private Music(double price, String description) {
        super(price, description);
    }

    public static Music getInstance(double price, String description) {
        return new Music(price, description);
    }

    public static Music getInstance(double price) {
        return new Music(price, "music");
    }
}
