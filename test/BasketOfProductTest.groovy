import salesTaxSolution.BasketOfProducts
import spock.lang.Specification

public class BasketOfProductTest extends Specification {
    BasketOfProducts basketOfProducts

    def "should calculate total price of basket"(){
        when:
        basketOfProducts=new BasketOfProducts(totalPrice:[45.67,67.56])
        then:
        basketOfProducts.getTotalPriceOfBasket()==113.23
    }

    def "should calculate total sales tax of basket"(){
        when:
        basketOfProducts=new BasketOfProducts(totalSalesTax:[45.67,67.56])
        then:
        basketOfProducts.getTotalSalesTaxForBasket()==113.23
    }

    def "should calculate the total for given basket 1"() throws Exception {
        when:
        String[] value = ["1 book at 12.49", "1 music CD at 14.99", "1 chocolate at 0.85"]
        basketOfProducts = new BasketOfProducts()
        basketOfProducts.getTheProductFromShop(value)

        then:
        basketOfProducts.getTotalPriceOfBasket()== 29.83
    }

    def "should calculate the total for given basket 2"() throws Exception {
        when:
        basketOfProducts = new BasketOfProducts()
        String[] value = ["1 imported  chocolate at 10.00", "1 imported bottle of perfume at 47.50"]
        then:
        basketOfProducts.getTotalPriceOfBasket() == 65.15
    }

    def "should calculate the total price for given basket 3"() throws Exception {
        when:
        String[] value = ["1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99", "1 packet of headache pills at 9.75", "1 box of imported chocolates at 11.25"]
        basketOfProducts = new BasketOfProducts()

        then:
        basketOfProducts.getTotalPriceOfBasket() == 74.68
    }
}


