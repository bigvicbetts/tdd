package TaxCalculator.Products;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FoodTests {

    @Test
    public void testGetDescription() {
        Product food = Food.getInstance(11.49, "grapes");
        String actual = food.getDescription();
        String expected = "grapes";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetDescription_GetDefaultDescription() {
        Product food = Food.getInstance(11.49);
        String actual = food.getDescription();
        String expected = "grapes";
        Assert.assertEquals(actual, expected);
    }
}
