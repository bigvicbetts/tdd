package TaxCalculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.NumberFormat;

public class CashRegister {

    private CashRegister() {

    }

    public static CashRegister getInstance() {
        return new CashRegister();
    }

    public BigDecimal calculateTaxRate(boolean isTaxExempt, boolean isImported) {
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

    public BigDecimal calculateTax(BigDecimal price, BigDecimal taxRate) {
        MathContext mc = new MathContext(2);
        BigDecimal tax = new BigDecimal(String.valueOf(price.multiply(taxRate)));
        tax = tax.multiply(new BigDecimal(String.valueOf(20)));
        double newTax = Math.ceil(tax.doubleValue());
        tax = new BigDecimal(String.valueOf(newTax)).divide(new BigDecimal(String.valueOf(20)));
        tax.round(mc);
        return tax;
    }
}

