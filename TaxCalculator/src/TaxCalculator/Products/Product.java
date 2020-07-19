package TaxCalculator.Products;

import java.math.BigDecimal;

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
}
