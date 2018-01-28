package designpartten.strategy.quack;

/**
 * @Author Vincent
 * @Date 2018/1/23 23:06
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("鸭子要呱呱叫...");
    }
}
