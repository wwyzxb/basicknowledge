package chapter1.original;

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
    private Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentalsEnumeration = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentalsEnumeration.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentalsEnumeration.nextElement();

            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }
            frequentRenterPoints++;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
