package TaxCalculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CashRegisterTests {

    @Test
    public void testCalculateTaxRate_TaxExemptAndNotImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal actual = cashRegister.calculateTaxRate(true, false);
        BigDecimal expected = new BigDecimal(String.valueOf(0.0));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTaxRate_NonTaxExemptAndNotImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal actual = cashRegister.calculateTaxRate(false, false);
        BigDecimal expected = new BigDecimal(String.valueOf(0.1));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTaxRate_TaxExemptAndImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal actual = cashRegister.calculateTaxRate(true, true);
        BigDecimal expected = new BigDecimal(String.valueOf(0.05));
        Assert.assertEquals(actual, expected);
    }
}
