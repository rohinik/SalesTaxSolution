import salesTaxSolution.Customer
import spock.lang.Specification

class CustomerTest extends Specification {
    def "should read the data from file"() {
        when:
        def productListFile = new File('ProductList')
        productListFile.write("1 imported book at 23.45\n")
        Customer customer = new Customer()

        then:
        String[] productInformation = customer.readProductsFromList()
        productInformation[0] == "1 imported book at 23.45"
    }
}
