package TaxCalculator.Products;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class FragranceTests {

    @Test
    public void testGetDescription() {
        Product fragrance = Fragrance.getInstance(11.49, "Something Smells");
        String actual = fragrance.getDescription();
        String expected = "Something Smells";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetDescription_GetDefaultDescription() {
        Product fragrance = Fragrance.getInstance(11.49);
        String actual = fragrance.getDescription();
        String expected = "fragrance";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetPrice() {
        Product fragrance = Fragrance.getInstance(11.49);
        BigDecimal actual = fragrance.getPrice();
        BigDecimal expected = new BigDecimal(String.valueOf("11.49"));
        Assert.assertEquals(actual, expected);
    }

}
