package TaxCalculator.Products;

import org.testng.Assert;
import org.testng.annotations.Test;

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
        String expected = "Something Smells";
        Assert.assertEquals(actual, expected);
    }
}
