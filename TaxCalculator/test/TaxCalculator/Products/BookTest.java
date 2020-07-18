package TaxCalculator.Products;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class BookTest {

    @Test
    public void testGetDescription() {
        Product book = Book.getInstance(11.49, "My Book");
        String actual = book.getDescription();
        String expected = "My Book";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetDescription_GetDefaultDescription() {
        Product book = Book.getInstance(11.49);
        String actual = book.getDescription();
        String expected = "book";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetPrice() {
        Product book = Book.getInstance(11.49);
        BigDecimal actual = book.getPrice();
        BigDecimal expected = new BigDecimal(String.valueOf(11.50));
        Assert.assertEquals(actual, expected);
    }
}
