import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ms on 4/16/14.
 */
public class CustomerTest {

    @Test
    public void testStatement() {
        Movie legoMovie = new Movie( "The Lego Movie", Movie.CHILDRENS );
        Movie watchmenMovie = new Movie( "Watchmen", Movie.REGULAR );

        Customer customer = new Customer( "Test" );
        customer.addRental( new Rental( legoMovie, 2 ) );
        customer.addRental( new Rental( watchmenMovie, 3 ) );

        assertThat( customer.statement(),
                is("Rental Record for Test\n\tThe Lego Movie\t1.5\n\tWatchmen\t3.5\nAmount owed is 5.0\nYou earned 2 frequent renter points") );

    }

    @Test
    public void testStatement2() {
        Movie frozenMovie = new Movie("Frozen II", Movie.NEW_RELEASE );

        Customer customer = new Customer("Test" );
        customer.addRental( new Rental( frozenMovie, 3 ) );

        assertThat( customer.statement(),
                is("Rental Record for Test\n\tFrozen II\t9.0\nAmount owed is 9.0\nYou earned 2 frequent renter points") );

    }

    @Test
    public void testStatement3() {
        Movie frozenMovie = new Movie("Frozen II", Movie.NEW_RELEASE);

        Customer customer = new Customer("Test");
        customer.addRental( new Rental(frozenMovie, 1) );

        assertThat( customer.statement(),
                is("Rental Record for Test\n\tFrozen II\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points") );

    }

}
