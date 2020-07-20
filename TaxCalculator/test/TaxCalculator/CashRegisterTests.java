package TaxCalculator;

import TaxCalculator.Products.Medicine;
import TaxCalculator.Products.Music;
import TaxCalculator.Products.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CashRegisterTests {

    @Test
    public void testAddProduct_OneInstance() {
        CashRegister cashRegister = CashRegister.getInstance();
        cashRegister.addProduct(Music.getInstance(14.99), false);
        String actual = cashRegister.getProducts().toString();
        String expected = new ArrayList<>(Arrays.asList(Music.getInstance(14.99))).toString();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAddProduct_MultipleInstance() {
        CashRegister cashRegister = CashRegister.getInstance();
        cashRegister.addProduct(Music.getInstance(14.99), false);
        cashRegister.addProduct(Medicine.getInstance(15.05, "Tylenol"), false);
        String actual = cashRegister.getProducts().toString();
        String expected = new ArrayList<>(Arrays.asList(Music.getInstance(14.99),
                Medicine.getInstance(15.05, "Tylenol"))).toString();
        Assert.assertEquals(actual, expected);
    }
}
