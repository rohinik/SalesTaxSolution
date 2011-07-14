package salesTaxSolution

public class Customer {
    public static void main(String[] args) {

        Customer customer = new Customer()
        BasketOfProducts basketOfProducts = new BasketOfProducts()
        String[] informationOfProducts = customer.readProductsFromList()
        basketOfProducts.getTheProductFromShop(informationOfProducts)
    }

    def readProductsFromList() {
        List line = new File("ProductList").readLines()
        line
    }
}