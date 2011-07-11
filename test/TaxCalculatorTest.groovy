import spock.lang.Specification
import utilities.TaxCalculator
import org.junit.Before
import salestaxsolution.Product
import utilities.ProductTaxConstants

public class TaxCalculatorTest extends Specification {


    def "tax calculator should not null"() {
        when:
        Product product = new Product(1, "book", 12.49)
        TaxCalculator taxCalculator = new TaxCalculator(product)

        then:
        taxCalculator
    }

    def "should calculate basic tax"() {
        when:
        Product product = new Product(1, "perfume", 12.49)
        TaxCalculator taxCalculator = new TaxCalculator(product)
        product.setItemType(ProductTaxConstants.LOCAL_TYPE)

        double value;
        try {
            value = taxCalculator.calculateBasicTax()

        }
        catch (Exception) {

        }
        then:

        value == 1.249


    }

    def "should import duty tax"() {
        when:
        Product product = new Product(1, "book", 12.49)
        TaxCalculator taxCalculator = new TaxCalculator(product)
        product.setItemType(ProductTaxConstants.IMPORTED_TYPE)

        double value;
        try {
            value = taxCalculator.calculateImportDutyTax()

        }
        catch (Exception) {

        }
        then:

        value == 0.6245


    }


}
