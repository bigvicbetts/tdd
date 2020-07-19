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
        CashRegister cashRegister = CashRegister.getInastance();
        cashRegister.addProduct(Music.getInstance(14.99));
        ArrayList<Product> actual = cashRegister.getProducts();
        ArrayList<Product> expected = new ArrayList<>(Arrays.asList(Music.getInstance(14.99)));
        Assert.assertEquals(actual, expected);
    }
}
