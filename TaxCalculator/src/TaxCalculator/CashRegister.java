package TaxCalculator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CashRegister {

    private CashRegister() {

    }

    public static CashRegister getInstance() {
        return new CashRegister();
    }

    public BigDecimal calculateTaxRate(boolean isTaxExempt, boolean isImported) {
        double nonExempt = 0.1;
        double imported = 0.05;
        double taxRate = 0.0;
        if (isTaxExempt && !isImported) {
            taxRate = 0.0;
        }
        return new BigDecimal(String.valueOf(taxRate));
    }
}

