import salesTaxSolution.Product
import salesTaxSolution.ShopKeeper
import spock.lang.Specification

class ShopkeeperTest extends Specification {
    Product[] products

    def "should read the data from file"() {
        when:
        def f2 = new File('ProductList')
        f2.write("check it\n")

        ShopKeeper shopKeeper = new ShopKeeper()
        then:
        String[] value = shopKeeper.readProductsFromFile()
        value[0] == "check it"
    }
}
