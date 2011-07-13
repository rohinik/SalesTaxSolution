package utilities

import salesTaxSolution.Product

public class TaxCalculator {
    private Product product
    def list = ["book", "chocolate", "medical", "pills", "milk"]

    def static calculateTotalPrice(double[] price) {
        double totalPrice = 0.0;
        for (int i = 0; i < price.length; i++) {
            totalPrice = totalPrice + price[i]
        }
        totalPrice
    }

    def static roundToNearestDecimalFive(Double number) {
        int temporaryNumber = (int) (round(number) * 100);
        int unitDigit = temporaryNumber % 10;
        if (unitDigit % 5 != 0) {
            temporaryNumber += Math.abs(unitDigit % 5 - 5)
        }
        double finalRoundedValue = temporaryNumber / 100.0;
        finalRoundedValue;
    }

    def static round(double value) {
            Double.parseDouble(String.format("%.2f", value))
    }

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
