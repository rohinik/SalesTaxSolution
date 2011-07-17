import salesTaxSolution.Shopkeeper
import spock.lang.Specification

class ShopkeeperTest extends Specification {
    def "should read the data from file"() {
        when:
        def productListFile = new File('ProductList')
        productListFile.write("1 imported book at 23.45\n")
        Shopkeeper customer = new Shopkeeper()

        then:
        String[] productInformation = customer.readProductsFromList()
        productInformation[0] == "1 imported book at 23.45"
    }
}
