import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ms on 4/16/14.
 */
public class CustomerTest {

    @Test
    public void testCustomer() {
        Movie legoMovie = new Movie( "The Lego Movie", new ChildrensPrice() );
        Movie watchmenMovie = new Movie( "Watchmen", new RegularPrice() );


        Customer customer = new Customer( "Test" );
        customer.addRental( new Rental( legoMovie, 2 ) );
        customer.addRental( new Rental( watchmenMovie, 3 ) );

        assertThat( customer.statement(),
                    is( "Rental Record for Test\n\tThe Lego Movie\t1.5\n\tWatchmen\t3.5\nAmount owed is 5.0\nYou earned 2 frequent renter points" ) );

    }

}
