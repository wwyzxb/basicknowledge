package chapter1.refactorying;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Vincent Wu
 * @datetime 2021/4/23 23:18
 */
@Getter
@Setter
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

}
