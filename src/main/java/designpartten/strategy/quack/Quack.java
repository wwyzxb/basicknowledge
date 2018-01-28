package designpartten.strategy.quack;

/**
 * @Author Vincent
 * @Date 2018/1/23 23:05
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("鸭子要吱吱叫...");
    }
}
