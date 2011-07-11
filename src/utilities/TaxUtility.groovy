package utilities

import salestaxsolution.Product

class TaxUtility {

    def static calculateTotal(double[] total) {
        double temp = 0.0;
        for (int i = 0; i < total.length; i++) {
            temp = temp + total[i]
        }
        temp
    }

    def static roundToNearestDecimalFive(Double number) {
        int temporaryNumber = (int) (round(number) * 100);
        int unitPlace = temporaryNumber % 10;
        if (unitPlace % 5 != 0) {
            temporaryNumber += Math.abs(unitPlace % 5 - 5)
        }
        double finalRoundedValue = temporaryNumber / 100.0;
        return finalRoundedValue;
    }

    def static round(double value) {
        double temp
        try {
            Double.parseDouble(String.format("%.2f", value))
        }
        catch (Exception) {}

    }

    def static extractName(String value, boolean flag) {
        String itemName
        if (!flag)
            itemName = value.substring(value.indexOf(ProductTaxConstants.SPACE) + 1, lastIndexOfSpaceInValue(value) - 3)
        else
            itemName = value.substring(value.lastIndexOf("imported") + 9, lastIndexOfSpaceInValue(value) - 3)
        itemName
    }

    def static processInformation(String value, Product[] item, int index) throws Exception {
        try {
            def itemQuantity = Integer.valueOf(extractQuantity(value))
            def flag = value.contains("imported") ? true : false
            def itemName = extractName(value, flag)
            def itemPrice = Double.valueOf(extractPrice(value))
            item[index] = new Product(itemQuantity, itemName, itemPrice)
            if (flag)
                item[index].setItemType(ProductTaxConstants.IMPORTED_TYPE)
            else
                item[index].setItemType(ProductTaxConstants.LOCAL_TYPE)
        }
        catch (Exception) {}
        return item
    }

    private static String extractPrice(String value) {
        String itemPrice = value.substring(lastIndexOfSpaceInValue(value) + 1, value.length())
        return itemPrice
    }

    private static int lastIndexOfSpaceInValue(String value) {
        return value.lastIndexOf(ProductTaxConstants.SPACE)
    }

    private static String extractQuantity(String value) {
        String itemQuantity = value.substring(0, value.indexOf(ProductTaxConstants.SPACE))
        itemQuantity
    }
}
