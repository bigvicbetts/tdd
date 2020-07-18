package TaxCalculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.fail;

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

    @Test
    public void testCalculateTaxRate_NonTaxExemptAndImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal actual = cashRegister.calculateTaxRate(false, true);
        BigDecimal expected = new BigDecimal(String.valueOf(0.15));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal actual = cashRegister.calculateTax(new BigDecimal(String.valueOf(1.99)), new BigDecimal(String.valueOf(0.0)));
        BigDecimal expected = new BigDecimal(String.valueOf("0.0"));
        Assert.assertEquals(actual, expected);
    }
}
