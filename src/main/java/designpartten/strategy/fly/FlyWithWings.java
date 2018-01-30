package designpartten.strategy.fly;

/**
 * @Author Vincent
 * @Date 2018/1/23 23:05
 */
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("挥动翅膀飞的鸭子...");
    }
}
