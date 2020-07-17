package TaxCalculator;

import java.math.BigDecimal;

public interface ProductInformation {

    public String getName();
    public BigDecimal getPrice();
    public boolean getIsTaxExempt();
    public boolean getIsImported();

}
