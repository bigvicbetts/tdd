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
    public void testCalculateTax_TaxExemptAndNotImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal itemTax = cashRegister.calculateTaxRate(true, false);
        BigDecimal actual = cashRegister.calculateTax(new BigDecimal(String.valueOf(1.99)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("0.000"));
        Assert.assertEquals(actual, expected);
    }
}
