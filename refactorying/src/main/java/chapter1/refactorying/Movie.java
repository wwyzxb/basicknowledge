package chapter1.refactorying;

import chapter1.refactorying.price.Price;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Vincent Wu
 * @datetime 2021/4/23 23:18
 */
@Getter
@Setter
public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN = 2;

    private String title;
    private Price price;

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

}
