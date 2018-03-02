package designpartten.decorate;

/**
 * @Author Vincent
 * @Date 2018/2/1 23:31
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,Mocha";
    }

    @Override
    public double cost() {
        return 0.2 + beverage.cost();
    }
}
