package TaxCalculator;

import TaxCalculator.Products.Product;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;

public class ReceiptPrinter {

    String hello;

    private ReceiptPrinter() {

    }

    public static ReceiptPrinter getInstance() {
        return new ReceiptPrinter();
    }

    public String formatReceiptItem(String itemDescription, BigDecimal totalPrice) {
        return itemDescription + "   " + NumberFormat.getCurrencyInstance().format(totalPrice);
    }
}
