package designpartten.strategy.fly;

/**
 * @Author Vincent
 * @Date 2018/1/23 23:05
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞的鸭子...");
    }
}
