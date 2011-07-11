import salesTaxSolution.BasketOfProducts
import salesTaxSolution.Product
import salesTaxSolution.Receipt
import spock.lang.Specification

class ReceiptTest extends Specification {

    def "should generate receipt"() {
        expect:
        Receipt.generateReceipt(new Product[0], new BasketOfProducts());

    }
}
