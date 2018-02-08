package designpartten.decorate;

/**
 * @Author Vincent
 * @Date 2018/2/1 23:27
 */
public abstract class  CondimentDecorator extends Beverage{
    Beverage beverage;
    public abstract String getDescription();
}
