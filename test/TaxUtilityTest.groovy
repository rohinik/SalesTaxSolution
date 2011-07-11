import salesTaxSolution.Product

import utilities.TaxUtility
import spock.lang.Specification

class TaxUtilityTest extends Specification {
    def "should round values"() {
        expect:
        TaxUtility.round(12.9999999) == 13.0
        TaxUtility.round(14.4999) != 15
    }

   def "should round values to nearest decimal"() {
        expect:
        TaxUtility.roundToNearestDecimalFive(35.899999) == 35.9
        TaxUtility.roundToNearestDecimalFive(14.4999) != 15
    }
}

