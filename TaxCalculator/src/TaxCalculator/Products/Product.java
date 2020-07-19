package TaxCalculator.Products;

import java.math.BigDecimal;
import java.text.NumberFormat;

public abstract class Product {

    private final BigDecimal PRICE;
    private final String DESCRIPTION;

    public Product(double PRICE, String DESCRIPTION) {
        this.PRICE = new BigDecimal(String.valueOf(PRICE));
        this.DESCRIPTION = DESCRIPTION;
    }

    public BigDecimal getPrice() {
        return this.PRICE;
    }

    public String getDescription() {
        return this.DESCRIPTION;
    }

    @Override
    public String toString() {
        return this.DESCRIPTION + ":  $" + this.PRICE;
    }
}
