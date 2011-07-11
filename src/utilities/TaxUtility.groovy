package utilities

import salesTaxSolution.Product

class TaxUtility {
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
        try {
            Double.parseDouble(String.format("%.2f", value))
        }
        catch (Exception) {}
    }

    def static extractName(String value) {
        String productName=value.substring(value.indexOf(TaxConstants.SPACE) + 1, indexOfLastBlankSpace(value) - 3)
        productName
    }


    def static processInformation(String value, Product[] product, int index) throws Exception {
        try {
            def itemQuantity = Integer.valueOf(extractQuantity(value))
            def isImported = value.contains("imported") ? true : false
            def productName = extractName(value)
            def itemPrice = Double.valueOf(extractPrice(value))
            product[index] = new Product(itemQuantity, productName, itemPrice)
            if (isImported)
                product[index].setItemType(TaxConstants.IMPORTED_TYPE)
            else
                product[index].setItemType(TaxConstants.LOCAL_TYPE)
        }
        catch (Exception) {}
        product
    }

    private static String extractPrice(String value) {
        String productPrice = value.substring(indexOfLastBlankSpace(value) + 1, value.length())
        productPrice
    }

    private static int indexOfLastBlankSpace(String value) {
        value.lastIndexOf(TaxConstants.SPACE)
    }

    private static String extractQuantity(String value) {
        String productQuantity = value.substring(0, value.indexOf(TaxConstants.SPACE))
        productQuantity
    }
}
