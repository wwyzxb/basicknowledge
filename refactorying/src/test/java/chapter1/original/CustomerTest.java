package chapter1.original;

import org.junit.Test;

/**
 * @author Vincent Wu
 * @datetime 2021/4/24 9:00
 */
public class CustomerTest {

    public static String getOriginalResults() {
        Rental rentalMovie1 = new Rental(new Movie("Love", Movie.REGULAR), 5);
        Rental rentalMovie2 = new Rental(new Movie("Books", Movie.NEW_RELEASE), 5);
        Rental rentalMovie3 = new Rental(new Movie("LionKing", Movie.CHILDREN), 5);

        Customer customer = new Customer("Vincent");
        customer.addRental(rentalMovie1);
        customer.addRental(rentalMovie2);
        customer.addRental(rentalMovie3);

        return customer.statement();
    }

    @Test
    public void testOriginalCustomer() {
        System.out.println(getOriginalResults());
    }
}