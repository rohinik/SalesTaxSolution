package salesTaxSolution

public class Customer {
    public static void main(String[] args) {
        Customer customer = new Customer()
        BasketOfProducts basketOfProducts = new BasketOfProducts()
        String[] informationOfProducts = customer.readProductsFromList()
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