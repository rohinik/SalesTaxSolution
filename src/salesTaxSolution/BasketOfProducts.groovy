package salesTaxSolution

import utilities.TaxCalculator

class BasketOfProducts {
    private double[] totalPrice = new double[10]
    private double[] totalSalesTax = new double[10]
    private Product[] products
    private int basketSize

    def getTotalPriceOfBasket() {
        (TaxCalculator.calculateTotalPrice(totalPrice) + getTotalSalesTaxForBasket()).round(2)
    }

    def getTotalSalesTaxForBasket() {
        TaxCalculator.calculateTotalPrice(totalSalesTax)
    }

    def getTheProductFromShop(String[] listOfProducts) {
        products = new Product[listOfProducts.size()]
        for (int i; i < listOfProducts.size(); i++) {
            products[i] = ProcessProductInformation.getProductFromBillInformation(listOfProducts[i])
            this.totalPrice[i] = products[i].getTotalPrice()
            this.totalSalesTax[i] = products[i].getTaxAmount()
        }
        ReceiptGenerator.generateReceipt(products, this)
    }
}

