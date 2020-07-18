package TaxCalculator.Products;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MusicTests {

    @Test
    public void testGetDescription() {
        Product music = Music.getInstance(11.49, "Bad Hair Day");
        String actual = music.getDescription();
        String expected = "Hello";
        Assert.assertEquals(actual, expected);
    }
}
