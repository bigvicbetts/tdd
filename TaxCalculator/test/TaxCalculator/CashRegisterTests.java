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
        BigDecimal expected = new BigDecimal(String.valueOf("0.0"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_NotTaxExemptAndNotImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal itemTax = cashRegister.calculateTaxRate(false, false);
        BigDecimal actual = cashRegister.calculateTax(new BigDecimal(String.valueOf(14.99)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("1.5"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_NotTaxExemptAndImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal itemTax = cashRegister.calculateTaxRate(false, true);
        BigDecimal actual = cashRegister.calculateTax(new BigDecimal(String.valueOf(27.99)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("4.2"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_TaxExemptAndImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal itemTax = cashRegister.calculateTaxRate(true, true);
        BigDecimal actual = cashRegister.calculateTax(new BigDecimal(String.valueOf(10.00)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("0.5"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_TaxExemptAndImported_RequireRounding() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal itemTax = cashRegister.calculateTaxRate(true, true);
        BigDecimal actual = cashRegister.calculateTax(new BigDecimal(String.valueOf(11.25)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf(".6"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_TaxExemptAndImported_RequireRounding_Part2() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal itemTax = cashRegister.calculateTaxRate(false, true);
        BigDecimal actual = cashRegister.calculateTax(new BigDecimal(String.valueOf(47.50)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("7.15"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTotalPrice_ExemptAndImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal price = new BigDecimal(String.valueOf(11.25));
        BigDecimal testTax = cashRegister.calculateTax(price, cashRegister.calculateTaxRate(true, true));
        BigDecimal actual = cashRegister.calculateTotalPrice(price, testTax);
        BigDecimal expected = new BigDecimal(String.valueOf("11.85"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTotalPrice_NonExemptAndImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal price = new BigDecimal(String.valueOf(47.50));
        BigDecimal testTax = cashRegister.calculateTax(price, cashRegister.calculateTaxRate(false, true));
        BigDecimal actual = cashRegister.calculateTotalPrice(price, testTax);
        BigDecimal expected = new BigDecimal(String.valueOf("54.65"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTotalPrice_ExemptAndNonImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal price = new BigDecimal(String.valueOf(9.75));
        BigDecimal testTax = cashRegister.calculateTax(price, cashRegister.calculateTaxRate(true, false));
        BigDecimal actual = cashRegister.calculateTotalPrice(price, testTax);
        BigDecimal expected = new BigDecimal(String.valueOf("9.75"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTotalPrice_NonExemptAndNonImported() {
        CashRegister cashRegister = CashRegister.getInstance();
        BigDecimal price = new BigDecimal(String.valueOf(14.99));
        BigDecimal testTax = cashRegister.calculateTax(price, cashRegister.calculateTaxRate(false, false));
        BigDecimal actual = cashRegister.calculateTotalPrice(price, testTax);
        BigDecimal expected = new BigDecimal(String.valueOf("16.49"));
        Assert.assertEquals(actual, expected);
    }
}
