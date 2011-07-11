package salesTaxSolution
import utilities.TaxUtility

class BasketOfProducts {
    private double[] totalPrice = new double[10]
    private double[] totalSalesTax = new double[10]
    private Product[] products
    private int size

    def getBasicPriceOfBasket() {
        TaxUtility.calculateTotalPrice(totalPrice)
    }

    def setTotalPriceOfProduct(double productTotal, int index) {
        this.totalPrice[index] = productTotal
    }

    def setTotalSalesTax(double salesTaxTotal, int index) {
        this.totalSalesTax[index] = salesTaxTotal
    }

    def getTotalSalesTaxOfBasket() {
        TaxUtility.calculateTotalPrice(totalSalesTax)
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

    def getSizeOfBasket() {
        size
    }

    def setSizeOfBasket(int size) {
        this.size = size
    }

    def getSalesTaxForEachProduct(int index) {
        totalSalesTax[index]
    }

    def createProducts(String value, int index) throws Exception {
        products = TaxUtility.processInformation(value, products, index)
        products[index].setTaxAmount()
        setTotalPriceOfProduct(products[index].getTotalPrice(), index)
        setTotalSalesTax(products[index].getTaxAmount(), index)
    }

    def processInput(String[] value, int index) {
        setSizeOfBasket(Integer.valueOf(index))
        products = new Product[getSizeOfBasket()]
        setProductsInBasket(products)
        try {
            for (int i; i < getSizeOfBasket(); i++) {
                createProducts(value[i], i)
            }
            Receipt.generateReceipt(products, this)
        }
        catch (Exception) {
        }
        getTotalPriceOfBasket().round(2)
    }
}
