import salestaxsolution.Product
import utilities.ProductTaxConstants
import utilities.TaxUtility
import spock.lang.Specification

class TaxUtilityTest extends Specification {

    def "should process information"() {
        expect:
        try {
            TaxUtility.processInformation("1,book,23.45", new Product[4], 0);
        }
        catch (Exception) {}


    }

    def "should calculate total"() {
        expect:
        def temp = TaxUtility.calculateTotal(new double[4])
    }

    def "should round values"() {
        expect:
        TaxUtility.round(12.9999999) == 13.0
        TaxUtility.round(14.4999) != 15
    }


}

