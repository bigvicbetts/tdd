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
        String expected = "Tylenol:   $15.99";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFormatBottomLine() {
        ReceiptPrinter receiptPrinter = ReceiptPrinter.getInstance();
        String actual = receiptPrinter.formatBottomLine(new BigDecimal(String.valueOf(6.70)), new BigDecimal(String.valueOf(74.68)));
        String expected = "Sales Tax: $6.70   Total: $74.68";
        Assert.assertEquals(actual, expected);
    }
}
