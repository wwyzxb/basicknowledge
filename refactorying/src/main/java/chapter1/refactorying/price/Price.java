package chapter1.refactorying.price;

/**
 * @author Vincent Wu
 * @datetime 2021/4/24 9:38
 */
public interface Price {
    public abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    default int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

}
