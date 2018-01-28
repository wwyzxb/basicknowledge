package designpartten.strategy.fly;

/**
 * @Author Vincent
 * @Date 2018/1/23 23:24
 */
public class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("带着火箭起飞的鸭子...");
    }
}
