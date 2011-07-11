package utilities

import salesTaxSolution.Product

public class TaxCalculator {
    private Product product
    def list = ["book", "chocolate", "medical", "pills", "milk"]

    def getProduct() {
        product
    }

    public TaxCalculator(Product product) {
        this.product = product
    }

    def calculateBasicTax() throws Exception {
        boolean isExempted = false
        for (i in list) {
            if (product.getName().contains(i)) {
                isExempted = true
                break
            }
        }
        (isExempted != true) ? ((product.getPrice()) * TaxConstants.BASIC_TAX) / 100 : 0.0

    }

    def calculateImportDuty() {
        (product.isImported) ? (product.getPrice() * TaxConstants.TAX_ON_IMPORTED_PRODUCT) / 100 : 0.0
    }
}
