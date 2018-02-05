package designpartten.decorate;

/**
 * @Author Vincent
 * @Date 2018/2/1 23:28
 */
public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
