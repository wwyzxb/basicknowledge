package chapter1.refactorying;

import chapter1.refactorying.price.ChildrenPrice;
import chapter1.refactorying.price.NewReleasePrice;
import chapter1.refactorying.price.RegularPrice;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Vincent Wu
 * @datetime 2021/4/24 9:08
 */
public class CustomerTest {
    public static String getRefactorResults() {
        Rental rentalMovie1 = new Rental(new Movie("Love", new RegularPrice()), 5);
        Rental rentalMovie2 = new Rental(new Movie("Books", new NewReleasePrice()), 5);
        Rental rentalMovie3 = new Rental(new Movie("LionKing", new ChildrenPrice()), 5);

        Customer customer = new Customer("Vincent");
        customer.addRental(rentalMovie1);
        customer.addRental(rentalMovie2);
        customer.addRental(rentalMovie3);

        return customer.statement();
    }

    @Test
    public void printRefactorResults() {
        System.out.println(getRefactorResults());
    }

    @Test
    public void testAssertion() {
        // 单元测试比对，重构前后两次输出的值是否相等
        assertEquals(CustomerTest.getRefactorResults(), chapter1.original.CustomerTest.getOriginalResults());
    }
}