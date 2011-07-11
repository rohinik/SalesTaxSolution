package utilities

import salestaxsolution.Product

public class TaxCalculator {
    private Product product
    def list = ["book", "chocolate", "medical", "prefume", "pills"]

    def getProduct() {
        product
    }

    public TaxCalculator(Product product) {
        this.product = product
    }

    def calculateBasicTax() throws Exception {
        boolean flag = false
        for (i in list) {
            if (product.getName().contains(i)) {
                flag = true
                break
            }
        }
        (flag != true) ? ((product.getPrice()) * 10) / 100 : 0.0

    }

    def calculateImportDutyTax() {
        (product.isImported) ? (product.getPrice() * 5) / 100 : 0.0
    }
}
