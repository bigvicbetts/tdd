package TaxCalculator;

import TaxCalculator.Products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ReceiptPrinter {

    String hello;

    private ReceiptPrinter() {

    }

    public static ReceiptPrinter getInstance() {
        return new ReceiptPrinter();
    }

    public void printReceipt(ArrayList<Product> products, BigDecimal totalTax, BigDecimal finalTotal) {
        hello = "Hello World";
    }
}
