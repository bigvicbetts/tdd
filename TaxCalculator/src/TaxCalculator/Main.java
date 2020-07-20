package TaxCalculator;

import TaxCalculator.Products.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Case #1");
        CashRegister cashRegister = CashRegister.getInstance();
        cashRegister.addProduct(Book.getInstance(12.49), false);
        cashRegister.addProduct(Music.getInstance(14.99, "music CD"), false);
        cashRegister.addProduct(Food.getInstance(0.85, "chocolate bar"), false);
        cashRegister.checkOut();

        System.out.println("\nCase #2");
        cashRegister.addProduct(Food.getInstance(10.00, "imported box of chocolates"), true);
        cashRegister.addProduct(Fragrance.getInstance(47.50, "botle of perfume"), true);
        cashRegister.checkOut();

        System.out.println("\nCase #3");
        cashRegister.addProduct(Fragrance.getInstance(27.99, "imported bottle of perfume"), true);
        cashRegister.addProduct(Fragrance.getInstance(18.99, "bottle of perfume"), false);
        cashRegister.addProduct(Medicine.getInstance(9.75, "packet of headache pills"), false);
        cashRegister.addProduct(Food.getInstance(11.25, "box of imported chocolates"), true);
        cashRegister.checkOut();
    }
}
