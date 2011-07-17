package salesTaxSolution
public class Shopkeeper {
    public static void generateReceipt(Product[] products, BasketOfProducts basketOfProducts) {
        println("******************************************************************************")
        println("RECEIPT")
        println("******************************************************************************")
        products.each{product->
                    println("\t" + product.getQuantity() +
                    "\t" + product.getName() + ":" +
                    "\t" + (product.getName().length() > 7 ? "" : "\t") + "\t" +
                    product.getNetTotalPrice().round(2))

        }
        println("******************************************************************************")
        println("\t\t\t\t\t Sales Tax :" + basketOfProducts.getTotalSalesTaxForBasket().round(2))
        println("\t\t\t\t\t Total:" + basketOfProducts.getTotalPriceOfBasket().round(2))

    }
}
