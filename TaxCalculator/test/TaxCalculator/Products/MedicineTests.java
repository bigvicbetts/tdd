package TaxCalculator.Products;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MedicineTests {

    @Test
    public void testGetDescription() {
        Product medicine = Medicine.getInstance(11.49, "acetaminophen");
        String actual = medicine.getDescription();
        String expected = "acetaminophen";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetDescription_GetDefaultDescription() {
        Product medicine = Medicine.getInstance(11.49);
        String actual = medicine.getDescription();
        String expected = "medicine";
        Assert.assertEquals(actual, expected);
    }

}
