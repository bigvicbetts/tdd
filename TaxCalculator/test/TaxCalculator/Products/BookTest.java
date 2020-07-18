package TaxCalculator.Products;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTest {

    @Test
    public void testGetDescription() {
        Product book = Book.getInstance(11.49, "My Book");
        String actual = book.getDescription();
        String expected = "My Book2";
        Assert.assertEquals(actual, expected);
    }
}
