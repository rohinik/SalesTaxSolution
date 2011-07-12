import salesTaxSolution.ProcessBillInformation
import salesTaxSolution.Product
import spock.lang.Specification

class ProcessBillInformationTest extends Specification {
    Product product

    def "should get the product information"() {
        when:
        String basket = "1 imported book at 24.50"
        product = ProcessBillInformation.getProductFromBillInformation(basket)
        then:
        product.name == "imported book"
    }
}
