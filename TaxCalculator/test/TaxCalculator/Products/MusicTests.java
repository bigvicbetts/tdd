package TaxCalculator.Products;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MusicTests {

    @Test
    public void testGetDescription() {
        Product music = Music.getInstance(11.49, "Bad Hair Day");
        String actual = music.getDescription();
        String expected = "Bad Hair Day";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetDescription_GetDefaultDescription() {
        Product music = Music.getInstance(11.49);
        String actual = music.getDescription();
        String expected = "Bad Hair Day";
        Assert.assertEquals(actual, expected);
    }
}
