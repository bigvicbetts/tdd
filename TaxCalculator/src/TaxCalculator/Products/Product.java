package TaxCalculator.Products;

import java.math.BigDecimal;

public abstract class Product {

    private final BigDecimal price;
    private final String description;

    public Product(double price, String description) {
        this.price = new BigDecimal(String.valueOf(price));
        this.description = description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }
}
