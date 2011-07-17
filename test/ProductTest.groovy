import salesTaxSolution.Product
import spock.lang.Specification

class ProductTest extends Specification {

    def "should create product"() {
        when:
        Product product = new Product(quantity: 1, name: "imported book", price: 45.56)
        product.setItemType("imported")

        then:
        product.getName() == "imported book"
        product.getPrice() == 45.56
        product.getQuantity() == 1
        product.isImported == true

    }

    def "should calculate total price of product"() {
        when:
        Product product = new Product(quantity: 2, name: "imported book", price: 45.56)
        product.setItemType("imported")
        then:

        product.getTotalPrice() == 91.12

    }

    def "should calculate net total price of product"() {
        when:
        Product product = new Product(quantity: 2, name: "imported book", price: 45.56)
        product.setItemType("imported")
        product.setTaxAmount()
        then:

        product.getNetTotalPrice() == 93.42

    }


    def "should calculate tax product"() {
        when:
        Product product = new Product(quantity: 2, name: "imported book", price: 45.56)
        product.setItemType("imported")
        then:

        product.calculateTax() == 2.3

    }


}
