package chapter1.refactorying.price;

import chapter1.refactorying.Movie;

/**
 * @author Vincent Wu
 * @datetime 2021/4/24 9:38
 */
public class RegularPrice implements Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
