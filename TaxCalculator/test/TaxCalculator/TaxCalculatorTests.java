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
