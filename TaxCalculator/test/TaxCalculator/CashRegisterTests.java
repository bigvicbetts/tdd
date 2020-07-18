package TaxCalculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class CashRegisterTests {

    @Test
    public void testCalculateTax() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal actual = cashRegister.calculateTax(new BigDecimal(3.0), true, true);
        BigDecimal expected = new BigDecimal(String.valueOf(BigDecimal.valueOf(3.0)));
        Assert.assertEquals(actual, expected);
    }
}
