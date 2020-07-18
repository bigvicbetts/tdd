<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>

The problem is to create a sales tax calculator that will calculate sales and import taxes based on the given criteria and display the results to the screen.  The quantity of each item purchased, as well as the item's pre-tax price will be given to the calculator.  The calculator will then calculate the the final total of each item (including the sales and/or import taxes) and display the item description and it's final price to the screen.  After each individual item/price combo has been displayed, it will also display the total taxes collected as well as the final total charged.

<h2>
    2. Planning the Solution
</h2>

My initial thoughts...

1. `Product` Class - This represents the ACTUAL item on the store shelf (i.e. the actual packet of medicine or box of chocolates).  It will have no methods and, at this point, will contain only a `ProductInformation` class instance containing the String productName, BigDecimal productPrice, boolean isTaxExempt, and boolean isImported.  This `ProductInformation` will be sent, via `BarcodeScanner`, to the `CashRegister`.

2. `BarcodeScanner` Class - This class will contain a method to copy the `ProductInformation` from the `Product` to the appropriate ArrayList in the `Register`.  This will be the only method for this class.

3. `Register` Class - This class will contain an ArrayList of `ProductInformation` instances.  It will also contain fields to store the calculated taxes and running total of all items scanned.  It will also have a method to printReceipt, which will print the receipt.

4. `ReceiptItem` Class - This class will store a String of the formatted text for each product to be printed on the `Receipt`.  This text will include (1) the quantity of that specific item purchased, (2) the item name, and (3) the total cost of that item (including all applicable taxes).

5.  `Recipt` Class - This class will be responsible for actually displaying ALL of the items purchased, as well as the total taxes collected and the total cost for all items purchased.  It will contain a method to createReceiptItem instance for each item in the `ProductInformation` list.  It will then display each `ReceiptItem` instance.  Once all `ReceiptItem`s are displayed, it will display the total taxes and the final total to be collected.

I will try to follow the SOLID and TDD principles as closely as I know how.  I believe that the way I have the project designed will aid in Single Responsiblity because each item has very clearly defined responsibilites that, logically, belong only to that item.  In accordance with Dependency Inversion, I will begin designing `Register` class first because it is the MOST dependent on the other items so, when I design the other elements, changes to `Register` can easily be made as necessary.

<h2>
    3. Executing the Plan
</h2>

1.  Create method to calculate the item tax based on the information provided.
2.  After contemplation, I've decided to first create a method to calculate the actual tax rate.  Only once that is completed will I create a method to actually calculate the tax.
*
*
*
*
*
*
*
<h2>
    4. Reflection / Refactor
</h2>

1.  After attending some learning sessions with Craig, I have decided that I will focus simply on one task at a time and let that guide my program design, rather than sticking with the plan that I laid out above.  Classes and methods will be added and tested as they become necessary.  Hopefully this will lead to proper design and functionality.

2. I initially started out with a method to calculate tax based on (1) the item price and (2) the boolean values representing whether the item was exempt from local sales tax and/or an imported good.  I have since decided that this process would be better if it were broken down into two smaller methods; one to determine the tax rate and a second one to actually calculate the tax.

*
*
*
*
*
*
*