import spock.lang.Specification
import utilities.TaxConstants

class TaxConstantsTest extends Specification {
    def "should not contain null"() {
        expect:
        TaxConstants.IMPORTED_TYPE != null
        TaxConstants.LOCAL_TYPE != null
        TaxConstants.SPACE != null
        TaxConstants.TAX_ON_IMPORTED_PRODUCT!=null
        TaxConstants.BASIC_TAX!=null
    }
}
