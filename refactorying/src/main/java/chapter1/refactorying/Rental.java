package chapter1.refactorying;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vincent Wu
 * @datetime 2021/4/23 23:34
 */
@Setter
@Getter
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    double getCharge() {
        return movie.getCharge(daysRented);
    }

    int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
