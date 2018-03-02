package designpartten.decorate;

/**
 * @Author Vincent
 * @Date 2018/2/1 23:28
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
