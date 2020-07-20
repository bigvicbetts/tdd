package TaxCalculator;

import TaxCalculator.Products.Food;
import TaxCalculator.Products.Medicine;
import TaxCalculator.Products.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CashRegister {

    private TaxCalculator taxCalculator = TaxCalculator.getInstance();
    private ArrayList<Product> products = new ArrayList<>();
    private BigDecimal totalUntaxed = new BigDecimal(String.valueOf(0.0));
    private BigDecimal finalTotal = new BigDecimal(String.valueOf(0.0));

    private CashRegister() {

    }

    public static CashRegister getInstance() {

        return new CashRegister();
    }

    public BigDecimal getTotalTax() {
        return this.finalTotal.subtract(this.totalUntaxed);
    }

    public BigDecimal getFinalTotal() {
        return this.finalTotal;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

}
