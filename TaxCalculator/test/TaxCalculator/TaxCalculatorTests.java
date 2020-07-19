package TaxCalculator;

import TaxCalculator.Products.Food;
import TaxCalculator.Products.Fragrance;
import TaxCalculator.Products.Medicine;
import TaxCalculator.Products.Music;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.fail;

public class TaxCalculatorTests {

    @Test
    public void testCalculateTaxRate_TaxExemptAndNotImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal actual = taxCalculator.calculateTaxRate(true, false);
        BigDecimal expected = new BigDecimal(String.valueOf(0.0));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTaxRate_NonTaxExemptAndNotImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal actual = taxCalculator.calculateTaxRate(false, false);
        BigDecimal expected = new BigDecimal(String.valueOf(0.1));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTaxRate_TaxExemptAndImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal actual = taxCalculator.calculateTaxRate(true, true);
        BigDecimal expected = new BigDecimal(String.valueOf(0.05));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTaxRate_NonTaxExemptAndImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal actual = taxCalculator.calculateTaxRate(false, true);
        BigDecimal expected = new BigDecimal(String.valueOf(0.15));
        Assert.assertEquals(actual, expected);
    }



    @Test
    public void testCalculateTax_TaxExemptAndNotImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal itemTax = taxCalculator.calculateTaxRate(true, false);
        BigDecimal actual = taxCalculator.calculateTax(new BigDecimal(String.valueOf(1.99)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("0.0"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_NotTaxExemptAndNotImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal itemTax = taxCalculator.calculateTaxRate(false, false);
        BigDecimal actual = taxCalculator.calculateTax(new BigDecimal(String.valueOf(14.99)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("1.5"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_NotTaxExemptAndImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal itemTax = taxCalculator.calculateTaxRate(false, true);
        BigDecimal actual = taxCalculator.calculateTax(new BigDecimal(String.valueOf(27.99)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("4.2"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_TaxExemptAndImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal itemTax = taxCalculator.calculateTaxRate(true, true);
        BigDecimal actual = taxCalculator.calculateTax(new BigDecimal(String.valueOf(10.00)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("0.5"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_TaxExemptAndImported_RequireRounding() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal itemTax = taxCalculator.calculateTaxRate(true, true);
        BigDecimal actual = taxCalculator.calculateTax(new BigDecimal(String.valueOf(11.25)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf(".6"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTax_TaxExemptAndImported_RequireRounding_Part2() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal itemTax = taxCalculator.calculateTaxRate(false, true);
        BigDecimal actual = taxCalculator.calculateTax(new BigDecimal(String.valueOf(47.50)), itemTax);
        BigDecimal expected = new BigDecimal(String.valueOf("7.15"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTotalPrice_ExemptAndImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal actual = taxCalculator.calculateTotalPrice(Food.getInstance(11.25), true);
        BigDecimal expected = new BigDecimal(String.valueOf("11.85"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTotalPrice_NonExemptAndImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal actual = taxCalculator.calculateTotalPrice(Fragrance.getInstance(47.50), true);
        BigDecimal expected = new BigDecimal(String.valueOf("54.65"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTotalPrice_ExemptAndNonImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal actual = taxCalculator.calculateTotalPrice(Medicine.getInstance(9.75), false);
        BigDecimal expected = new BigDecimal(String.valueOf("9.75"));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTotalPrice_NonExemptAndNonImported() {
        TaxCalculator taxCalculator = TaxCalculator.getInstance();
        BigDecimal actual = taxCalculator.calculateTotalPrice(Music.getInstance(14.99), false);
        BigDecimal expected = new BigDecimal(String.valueOf("16.49"));
        Assert.assertEquals(actual, expected);
    }
}
