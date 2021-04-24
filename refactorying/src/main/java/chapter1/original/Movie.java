package chapter1.original;

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
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

}
