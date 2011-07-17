package salesTaxSolution

import utilities.TaxConstants

class ProcessProductInformation {
    def static getProductFromBillInformation(String value) {
        def productQuantity = Integer.valueOf(extractQuantity(value))
        def isImported = value.contains("imported") ? true : false
        def productName = extractName(value)
        def productPrice = Double.valueOf(extractPrice(value))
        Product product = new Product(quantity: productQuantity, name: productName, price: productPrice)
        if (isImported)
            product.setItemType(TaxConstants.IMPORTED)
        else
            product.setItemType(TaxConstants.LOCAL)
        product.setTaxAmount()
        product
    }

    private static String extractPrice(String value) {
        value.substring(indexOfLastBlankSpace(value) + 1, value.length())
    }

    private static int indexOfLastBlankSpace(String value) {
        value.lastIndexOf(TaxConstants.SPACE)
    }

    private static String extractQuantity(String value) {
        value.substring(0, value.indexOf(TaxConstants.SPACE))
    }

    def static extractName(String value) {
        value.substring(value.indexOf(TaxConstants.SPACE) + 1, indexOfLastBlankSpace(value) - 3)
    }
}
