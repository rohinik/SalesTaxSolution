package salesTaxSolution

public class ShopKeeper {
    public static void main(String[] args) {

        ShopKeeper shopKeeper = new ShopKeeper()
        BasketOfProducts basketOfProducts = new BasketOfProducts()
        String[] informationOfProducts = shopKeeper.readProductsFromFile()
        basketOfProducts.createProduct(informationOfProducts)
    }

    def readProductsFromFile() {
        List line = new File("ProductList").readLines()
        line
    }
}