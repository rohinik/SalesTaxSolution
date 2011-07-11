package salesTaxSolution

public class ShopKeeper {
    public static void main(String[] args) {

        ShopKeeper shopKeeper = new ShopKeeper()
        BasketOfProducts batchOfProducts = new BasketOfProducts()
        String[] informationOfProducts = shopKeeper.readProductsFromFile()
        double grandTotal = batchOfProducts.processInput(informationOfProducts, informationOfProducts.size())
    }

    def readProductsFromFile() {
        List line = new File("ProductList").readLines()
        line
    }
}