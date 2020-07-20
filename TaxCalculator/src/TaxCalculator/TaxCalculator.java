package TaxCalculator;

import TaxCalculator.Products.Book;
import TaxCalculator.Products.Food;
import TaxCalculator.Products.Medicine;
import TaxCalculator.Products.Product;

import java.math.BigDecimal;
import java.math.MathContext;

public class TaxCalculator {

    private TaxCalculator() {

    }

    public static TaxCalculator getInstance() {
        return new TaxCalculator();
    }

    private BigDecimal calculateTaxRate(boolean isTaxExempt, boolean isImported) {
        int nonExemptRate = 10;
        int importedRate = 5;
        double taxRate = 0;
        if (!isTaxExempt) {
            taxRate += nonExemptRate;
        }
        if (isImported) {
            taxRate += importedRate;
        }
        return new BigDecimal(String.valueOf(taxRate/100));
    }

    private BigDecimal calculateTax(BigDecimal price, BigDecimal taxRate) {
        MathContext mc = new MathContext(2);
        BigDecimal tax = new BigDecimal(String.valueOf(price.multiply(taxRate)));
        tax = tax.multiply(new BigDecimal(String.valueOf(20)));
        double newTax = Math.ceil(tax.doubleValue());
        tax = new BigDecimal(String.valueOf(newTax)).divide(new BigDecimal(String.valueOf(20)));
        tax.round(mc);
        return tax;
    }

    public BigDecimal calculateTotalPrice(Product product, boolean isImported) {
        boolean isTaxExempt = false;
        if (product.getClass() == Food.getInstance(0.0).getClass() ||
        product.getClass() == Medicine.getInstance(0.0).getClass() ||
        product.getClass() == Book.getInstance(0.0).getClass()) {
            isTaxExempt = true;
        }
        BigDecimal tax = new BigDecimal(String.valueOf(calculateTax(product.getPrice(),
                calculateTaxRate(isTaxExempt, isImported))));

        return product.getPrice().add(tax);
    }
}

