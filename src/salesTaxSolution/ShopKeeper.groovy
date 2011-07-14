package salesTaxSolution


public class Shopkeeper {
    public static void generateReceipt(Product[] products, BasketOfProducts basketOfProducts) {
        println("******************************************************************************")
        println("RECEIPT")
        println("******************************************************************************")

        for (int i = 0; i < products.length; i++) {
            println("\t" + products[i].getQuantity() +
                    "\t" + products[i].getName() + ":" +
                    "\t" + (products[i].getName().length() > 7 ? "" : "\t") + "\t" +
                    products[i].getNetTotalPrice().round(2))

        }
        println("******************************************************************************")
        println("\t\t\t\t\t Sales Tax :" + basketOfProducts.getTotalSalesTaxForBasket().round(2))
        println("\t\t\t\t\t Total:" + basketOfProducts.getTotalPriceOfBasket().round(2))

    }
}
