package designpartten.duck.quack;

/**
 * @Author Vincent
 * @Date 2018/1/23 23:06
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫的鸭子...");
    }
}
