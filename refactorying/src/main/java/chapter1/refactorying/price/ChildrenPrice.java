package chapter1.refactorying.price;

import chapter1.refactorying.Movie;

/**
 * @author Vincent Wu
 * @datetime 2021/4/24 9:38
 */
public class ChildrenPrice implements Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
