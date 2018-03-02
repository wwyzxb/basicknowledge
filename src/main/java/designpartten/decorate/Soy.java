package designpartten.decorate;

/**
 * @Author Vincent
 * @Date 2018/2/1 23:31
 */
public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Soy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
