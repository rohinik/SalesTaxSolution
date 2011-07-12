package salesTaxSolution

import utilities.TaxCalculator

class BasketOfProducts {
    private double[] totalPrice = new double[10]
    private double[] totalSalesTax = new double[10]
    private Product[] products
    private int size

    def getBasicPriceOfBasket() {
        TaxCalculator.calculateTotalPrice(totalPrice)
    }

    def setTotalPriceOfProduct(double productTotal, int index) {
        this.totalPrice[index] = productTotal
    }

    def setTotalSalesTax(double salesTaxTotal, int index) {
        this.totalSalesTax[index] = salesTaxTotal
    }

    def getTotalSalesTaxOfBasket() {
        TaxCalculator.calculateTotalPrice(totalSalesTax)
    }

    def getTotalPriceOfBasket() {
        (getBasicPriceOfBasket() + getTotalSalesTaxOfBasket())
    }

    def getProductsFromBasket(int index) {
        products[index]
    }

    def setProductsInBasket(Product[] products) {
        this.products = products
    }

    def getSalesTaxForEachProduct(int index) {
        totalSalesTax[index]
    }

    def createProduct(String[] billInformation) {
        products = new Product[billInformation.size()]
        setProductsInBasket(products)
        for (int i; i < billInformation.size(); i++) {
            products[i] = ProcessBillInformation.getProductFromBillInformation(billInformation[i])
            setTotalPriceOfProduct(products[i].getTotalPrice(), i)
            setTotalSalesTax(products[i].getTaxAmount(), i)
        }
        Receipt.generateReceipt(products, this)
        getTotalPriceOfBasket().round(2)
    }

}
