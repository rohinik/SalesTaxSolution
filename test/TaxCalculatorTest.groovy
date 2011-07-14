import salesTaxSolution.Product
import spock.lang.Specification
import utilities.TaxCalculator
import utilities.TaxConstants

public class TaxCalculatorTest extends Specification {

    def "should calculate basic tax"() {
        when:
        Product product = new Product(quantity: 1, name: "perfume", price: 12.49)
        TaxCalculator taxCalculator = new TaxCalculator(product)
        product.setItemType(TaxConstants.LOCAL_TYPE)
        double basicTaxValue
        basicTaxValue = taxCalculator.calculateBasicTax()

        then:
        basicTaxValue == 1.249
    }

    def "should calculate import duty"() {
        when:
        Product product = new Product(quantity: 1, name: "book", price: 12.49)
        TaxCalculator taxCalculator = new TaxCalculator(product)
        product.setItemType(TaxConstants.IMPORTED_TYPE)
        double importedTaxValue
        importedTaxValue = taxCalculator.calculateImportDuty()

        then:
        importedTaxValue == 0.6245
    }

    def "should round the number to the nearest decimal"() {
        expect:
        TaxCalculator.roundToNearestDecimalFive(45.4988) == 45.5
        TaxCalculator.roundToNearestDecimalFive(12.888) == 12.9
    }

    def "should round the number by 2 digits"() {
        expect:
        TaxCalculator.round(45.3333) == 45.33
        TaxCalculator.round(12.9888) == 12.99
    }
}
