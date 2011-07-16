package salesTaxSolution

import utilities.TaxCalculator
import utilities.TaxConstants

class Product {
    int quantity
    String name
    double price
    String itemType
    double taxAmount
    TaxCalculator taxCalculator
    boolean isImported;

    def setItemType(String itemType) {
        if (itemType.equalsIgnoreCase(TaxConstants.IMPORTED_TYPE))
            isImported = true
        else
            isImported = false
        this.itemType = itemType
    }

    def getTotalPrice() {
        this.quantity * this.getPrice()
    }

    def setTaxAmount() {
        this.taxAmount = calculateTax()
    }

    def getNetTotalPrice() {
        getTotalPrice() + getTaxAmount()
    }

    def double calculateTax() throws Exception {
        taxCalculator = new TaxCalculator(this)
        double temp = taxCalculator.calculateBasicTax() + taxCalculator.calculateImportDuty()
        taxAmount = taxCalculator.roundToNearestDecimalFive(temp)
    }
}