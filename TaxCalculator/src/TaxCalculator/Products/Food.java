package TaxCalculator.Products;

public class Food extends Product {

    private Food(double price, String description) {
        super(price, description);
    }

    public static Food getInstance(double price, String description) {
        return new Food(price, description);
    }

    public static Food getInstance(double price) {
        return new Food(price, "food");
    }
}
