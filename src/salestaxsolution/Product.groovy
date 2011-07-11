package salesTaxSolution

import utilities.TaxCalculator
import utilities.TaxConstants
import utilities.TaxUtility

class Product {
    private int quantity
    private String name
    private double price
    private String itemType
    private double taxAmount
    private TaxCalculator taxCalculator
    public boolean isImported;

    public Product(int quantity, String name, double price) {
        this.quantity = quantity
        this.name = name
        this.price = price
        taxCalculator = new TaxCalculator(this)
    }

    def getQuantity() {
        quantity
    }

    def setQuantity(int quantity) {
        this.quantity = quantity
    }

    def getName() {
        this.name
    }

    def setName(String name) {
        this.name = name
    }

    def getPrice() {
        price
    }

    def setPrice(double price) {
        this.price = price
    }

    def getItemType() {
        itemType
    }

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

    def getTaxAmount() {
        taxAmount
    }

    def setTaxAmount() {
        this.taxAmount = calculateTax()
    }

    def getNetTotalPrice() {
        getTotalPrice() + getTaxAmount()
    }

    def double calculateTax() throws Exception {
        double temp = taxCalculator.calculateBasicTax() + taxCalculator.calculateImportDuty()
        TaxUtility.roundToNearestDecimalFive(temp)
    }
}