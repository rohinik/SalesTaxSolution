package salesTaxSolution

import utilities.TaxCalculator

class BasketOfProducts {
    private double[] totalPrice = new double[10]
    private double[] totalSalesTax = new double[10]
    private Product[] products
    private int basketSize

    def getTotalPriceOfBasket() {
        (TaxCalculator.calculateTotalPrice(totalPrice) + getTotalSalesTaxForBasket())
    }

    def getTotalSalesTaxForBasket() {
        TaxCalculator.calculateTotalPrice(totalSalesTax)
    }

    def getTheProductFromShop(String[] listOfProducts) {
        products = new Product[listOfProducts.size()]
        this.products = products
        for (int i; i < listOfProducts.size(); i++) {
            products[i] = ProcessBillInformation.getProductFromBillInformation(listOfProducts[i])
            this.totalPrice[i] = products[i].getTotalPrice()
            this.totalSalesTax[i] = products[i].getTaxAmount()
        }
        Shopkeeper.generateReceipt(products, this)
        getTotalPriceOfBasket().round(2)
    }

}

