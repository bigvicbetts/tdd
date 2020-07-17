package TaxCalculator;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal price;
    private boolean isTaxExempt;
    private boolean isImported;
    ProductInformation productInfo;

    public Product(String name, BigDecimal price, boolean isTaxExempt, boolean isImported) {
        this.name = name;
        this.price = price;
        this.isTaxExempt = isTaxExempt;
        this.isImported = isImported;
    }
}
