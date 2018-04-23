import java.util.ArrayList;
import java.util.List;

/**
 * Created by ms on 4/16/14.
 */
public class Customer {

    private String       _name;
    private List<Rental> _rentals = new ArrayList<>();



    public Customer( String name ) {
        _name = name;
    }



    public void addRental( Rental arg ) {
        _rentals.add( arg );
    }



    public String getName() {
        return _name;
    }



    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for ( Rental rental : _rentals ) {
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf( rental.getCharge() ) + "\n";
        }
        //add foooter lines
        result += "Amount owed is " + String.valueOf( getTotalCharge() ) + "\n";
        result += "You earned " + String.valueOf( getTotalFrequentRenterPoints() ) + " frequent renter points";
        return result;
    }



    public String htmlStatement() {
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        for ( Rental rental : _rentals ) {
            //show figures for each rental
            result += rental.getMovie().getTitle() + ": " + String.valueOf( rental.getCharge() ) + "</BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf( getTotalCharge() ) + ">/EM></P>\n";
        result += "On this rental you earned <EM>" + String
                .valueOf( getTotalFrequentRenterPoints() ) + "</EM> frequent renter points</P>";
        return result;
    }



    private double getTotalCharge() {
        double result = 0;
        for ( Rental rental : _rentals ) {
            result += rental.getCharge();
        }
        return result;
    }



    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for ( Rental rental : _rentals ) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

}
