package salesTaxSolution

import utilities.TaxConstants

class ProcessBillInformation {

    def static getProductFromBillInformation(String value) {
        def itemQuantity = Integer.valueOf(extractQuantity(value))
        def isImported = value.contains("imported") ? true : false
        def productName = extractName(value)
        def itemPrice = Double.valueOf(extractPrice(value))
        Product product = new Product(quantity: itemQuantity, name: productName, price: itemPrice)
        if (isImported)
            product.setItemType(TaxConstants.IMPORTED_TYPE)
        else
            product.setItemType(TaxConstants.LOCAL_TYPE)
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
