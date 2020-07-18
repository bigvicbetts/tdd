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
        int nonExemptRate = 10;
        int importedRate = 5;
        double taxRate = 0;
        //BigDecimal taxRate = new BigDecimal(String.valueOf(0.0));
        if (!isTaxExempt) {
            taxRate += nonExemptRate;
        }
        if (isImported) {
            taxRate += importedRate;
        }
        return new BigDecimal(String.valueOf(taxRate/100));
    }
}

