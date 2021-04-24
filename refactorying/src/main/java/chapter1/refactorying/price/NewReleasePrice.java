package chapter1.refactorying.price;

import chapter1.refactorying.Movie;

/**
 * @author Vincent Wu
 * @datetime 2021/4/24 9:38
 */
public class NewReleasePrice implements Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
