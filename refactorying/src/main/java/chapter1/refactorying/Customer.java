package chapter1.refactorying;

import lombok.Getter;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Vincent Wu
 * @datetime 2021/4/23 23:35
 */
public class Customer {
    @Getter
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String statement() {
        Enumeration rentalsEnumeration = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentalsEnumeration.hasMoreElements()) {
            Rental each = (Rental) rentalsEnumeration.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentalsEnumeration = rentals.elements();
        while (rentalsEnumeration.hasMoreElements()) {
            Rental each = (Rental) rentalsEnumeration.nextElement();
            result += each.getCharge();
        }
        return result;

    }

    private int getFrequentRenterPoints() {
        int result = 0;
        Enumeration rentalsEnumeration = rentals.elements();
        while (rentalsEnumeration.hasMoreElements()) {
            Rental each = (Rental) rentalsEnumeration.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }


}
