package TaxCalculator;

import TaxCalculator.Products.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ReceiptPrinterTests {

    @Test
    public void testPrintReceipt() {
        ReceiptPrinter receiptPrinter = ReceiptPrinter.getInstance();
        receiptPrinter.printReceipt(new ArrayList<Product>(), new BigDecimal(String.valueOf(0.0)), new BigDecimal(String.valueOf(0.0)));
        String actual = receiptPrinter.hello;
        String expected = "Hello World";
        Assert.assertEquals(actual, expected);
    }
}
