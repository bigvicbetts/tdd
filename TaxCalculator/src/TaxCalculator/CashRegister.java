package TaxCalculator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CashRegister {

    private CashRegister() {

    }

    public static CashRegister getInstance() {
        return new CashRegister();
    }

    public BigDecimal calculateTax(BigDecimal price, boolean isTaxExempt, boolean isImported) {
        double value = 3.0;
        return new BigDecimal(String.valueOf(BigDecimal.valueOf(value)));
    }
}

