package TaxCalculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CashRegisterTests {

    @Test
    public void testCalculateTaxRate() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal actual = cashRegister.calculateTaxRate(true, true);
        BigDecimal expected = new BigDecimal(String.valueOf(3.0));
        Assert.assertEquals(actual, expected);
    }
}
