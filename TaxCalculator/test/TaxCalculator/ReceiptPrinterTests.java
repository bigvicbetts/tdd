package TaxCalculator;

import TaxCalculator.Products.Fragrance;
import TaxCalculator.Products.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class ReceiptPrinterTests {

    @Test
    public void testFormatReceiptItem() {
        ReceiptPrinter receiptPrinter = ReceiptPrinter.getInstance();
        String actual = receiptPrinter.formatReceiptItem("Tylenol", new BigDecimal(String.valueOf(15.99)));
        String expected = "Hello World";
        Assert.assertEquals(actual, expected);
    }
}
