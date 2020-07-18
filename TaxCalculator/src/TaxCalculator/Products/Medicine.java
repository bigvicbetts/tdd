package TaxCalculator.Products;

public class Medicine extends Product {

    private Medicine(double price, String description) {
        super(price, description);
    }

    public static Medicine getInstance(double price, String description) {
        return new Medicine(price, description);
    }

    public static Medicine getInstance(double price) {
        return new Medicine(price, "medicine");
    }
}
