import salesTaxSolution.Product
import spock.lang.Specification
import utilities.TaxCalculator
import utilities.TaxConstants

public class TaxCalculatorTest extends Specification {

    def "should calculate basic tax"() {
        when:
        Product product = new Product(1, "perfume", 12.49)
        TaxCalculator taxCalculator = new TaxCalculator(product)
        product.setItemType(TaxConstants.LOCAL_TYPE)
        double basicTaxValue
        try {
            basicTaxValue = taxCalculator.calculateBasicTax()
        }
        catch (Exception) {
        }
        then:
        basicTaxValue == 1.249
    }

    def "should calculate import duty"() {
        when:
        Product product = new Product(1, "book", 12.49)
        TaxCalculator taxCalculator = new TaxCalculator(product)
        product.setItemType(TaxConstants.IMPORTED_TYPE)
        double importedTaxValue
        try {
            importedTaxValue = taxCalculator.calculateImportDuty()
        }
        catch (Exception) {
        }
        then:

        importedTaxValue == 0.6245
    }
}
