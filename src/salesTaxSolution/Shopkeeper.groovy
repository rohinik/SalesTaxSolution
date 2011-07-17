package salesTaxSolution

public class Shopkeeper {
    public static void main(String[] args) {
        Shopkeeper shopkeeper = new Shopkeeper()
        BasketOfProducts basketOfProducts = new BasketOfProducts()
        String[] informationOfProducts = shopkeeper.readProductsFromList()
        basketOfProducts.getTheProductFromShop(informationOfProducts)
    }

    def readProductsFromList() {
        try {
            List line = new File("ProductList").readLines()
            line
        }
        catch (Exception e) {

            print "Please create ProductList"
        }
    }
}