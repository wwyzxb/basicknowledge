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
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String statement() {
        Enumeration<Rental> rentalsEnumeration = rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while (rentalsEnumeration.hasMoreElements()) {
            Rental each = rentalsEnumeration.nextElement();
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getCharge()).append("\n");
        }
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentalsEnumeration = rentals.elements();
        while (rentalsEnumeration.hasMoreElements()) {
            Rental each = rentalsEnumeration.nextElement();
            result += each.getCharge();
        }
        return result;

    }

    private int getFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentalsEnumeration = rentals.elements();
        while (rentalsEnumeration.hasMoreElements()) {
            Rental each = rentalsEnumeration.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }


}
