import salesTaxSolution.BasketOfProducts
import spock.lang.Specification

public class BasketOfProductTest extends Specification {
    BasketOfProducts basketOfProducts

    def "should calculate the tax for given input 1"() throws Exception {
        when:
        String[] value = ["1 book at 12.49", "1 music CD at 14.99", "1 chocolate at 0.85"]
        basketOfProducts = new BasketOfProducts()
        double grandTotal = basketOfProducts.createProduct(value)

        then:
        grandTotal == 29.83
    }

    def "should calculate the tax for given input 2"() throws Exception {
        when:
        basketOfProducts = new BasketOfProducts()
        String[] value = ["1 imported  chocolate at 10.00", "1 imported bottle of perfume at 47.50"]
        double grandTotal = basketOfProducts.createProduct(value)

        then:
        grandTotal == 65.15
    }

    def "should calculate the tax for given input 3"() throws Exception {
        when:
        String[] value = ["1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99", "1 packet of headache pills at 9.75", "1 box of imported chocolates at 11.25"]
        basketOfProducts = new BasketOfProducts()
        double grandTotal = basketOfProducts.createProduct(value)

        then:
        grandTotal == 74.68
    }
}


