package TaxCalculator.Products;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

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
        String expected = "food";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetPrice() {
        Product food = Food.getInstance(11.49);
        BigDecimal actual = food.getPrice();
        BigDecimal expected = new BigDecimal(String.valueOf(11.50));
        Assert.assertEquals(actual, expected);
    }
}
