package designpartten.strategy.specificduck;

import designpartten.strategy.Duck;
import designpartten.strategy.fly.FlyNoWay;
import designpartten.strategy.quack.MuteQuack;
import org.junit.Test;

/**
 * @Author Vincent
 * @Date 2018/1/23 23:12
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior =new FlyNoWay();
        quackBehavior=new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是绿色的...");
    }

    @Test
    public void testMallardDuck(){
        Duck duck=new MallardDuck();
        duck.performFly();
        duck.performQuack();
        duck.display();
    }
}
