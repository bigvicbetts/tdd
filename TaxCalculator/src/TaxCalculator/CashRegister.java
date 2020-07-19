package TaxCalculator;

import java.math.BigDecimal;

public class CashRegister {

    TaxCalculator taxCalculator = TaxCalculator.getInstance();
    BigDecimal totalTax;
    BigDecimal finalTotal;

    private CashRegister() {

    }

    public static CashRegister getInastance() {
        return new CashRegister();
    }

}
