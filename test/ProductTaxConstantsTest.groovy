import spock.lang.Specification
import utilities.ProductTaxConstants

class ProductTaxConstantsTest extends Specification {

    def "should not contain null"() {
        expect:
        ProductTaxConstants.IMPORTED_TYPE != null

        ProductTaxConstants.LOCAL_TYPE != null
        ProductTaxConstants.SPACE != null

    }


}
