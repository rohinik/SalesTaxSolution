import utilities.ProductTaxConstants
import spock.lang.Specification
import salestaxsolution.Product;


public class ProductTest extends Specification {
    Product product = new Product(1, "book", 12.49)

    def "should get the quantity"() {
        expect:
        product.getQuantity() == 1
    }

    def "should set the quantity"() {
        when:
        product.setQuantity(2)
        then:
        product.getQuantity() == 2

    }

    def "should get the name"() {

        expect:
        product.getName() == "book"

    }

    def "should set the name"() {
        when:
        product.setName("chocolate")

        then:
        product.getName() == "chocolate"
    }

    def "should get the price"() {
        expect:
        product.getPrice() == 12.49
    }

    def "should set the price"() {
        when:
        product.setPrice(12.34)

        then:
        product.getPrice() == 12.34
    }

    def "should get the item type"() {
        when:
        product.setItemType("IMPORTED")
        then:
        product.getItemType() == ProductTaxConstants.IMPORTED_TYPE
    }

    def "should get total"() {
        expect:
        product.getTotal() == 12.49

    }

    def "should get tax amount"() {

        expect:
        product.getTaxAmount() == 0.0


    }



}


