package TaxCalculator;

import TaxCalculator.Products.Food;
import TaxCalculator.Products.Medicine;
import TaxCalculator.Products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class CashRegister {

    private TaxCalculator taxCalculator = TaxCalculator.getInstance();
    private ReceiptPrinter receiptPrinter = ReceiptPrinter.getInstance();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Boolean> isImported = new ArrayList<>();
    private BigDecimal subtotal = new BigDecimal(String.valueOf(0.0));
    private BigDecimal finalTotal = new BigDecimal(String.valueOf(0.0));

    private CashRegister() {}

    public static CashRegister getInstance() {

        return new CashRegister();
    }

    public BigDecimal getTotalTax() {
        BigDecimal totalTax = finalTotal.subtract(subtotal);
        return totalTax;
    }

    public BigDecimal getFinalTotal() {
        return this.finalTotal;
    }

    public void addProduct(Product product, Boolean imported) {
        products.add(product);
        isImported.add(imported);
    }

    public void checkOut() {
        for (int i = 0; i < products.size(); i++) {
            subtotal = subtotal.add(products.get(i).getPrice());
            BigDecimal totalPrice = taxCalculator.calculateTotalPrice(products.get(i), isImported.get(i));
            finalTotal = finalTotal.add(totalPrice);
            System.out.println(receiptPrinter.formatReceiptItem(Collections.frequency(products, products.get(i)), products.get(i).getDescription(), totalPrice));
        }

        System.out.println(receiptPrinter.formatBottomLine(getTotalTax(), finalTotal));
        reset();
    }

    private void reset() {
        products = new ArrayList<>();
        isImported = new ArrayList<>();
        subtotal = new BigDecimal(String.valueOf(0.0));
        finalTotal = new BigDecimal(String.valueOf(0.0));
    }
    public ArrayList<Product> getProducts() {
        return this.products;
    }

}
