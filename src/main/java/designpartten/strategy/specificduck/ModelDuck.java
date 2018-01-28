package designpartten.strategy.specificduck;

import designpartten.strategy.Duck;
import designpartten.strategy.fly.FlyNoWay;
import designpartten.strategy.fly.FlyWithRocket;
import designpartten.strategy.quack.MuteQuack;
import org.junit.Test;

/**
 * @Author Vincent
 * @Date 2018/1/23 23:21
 */
public class ModelDuck extends Duck{
    public ModelDuck() {
        flyBehavior=new FlyNoWay();
        quackBehavior=new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是一直模型鸭子...");
    }

    @Test
    public void testModelDuck(){
        Duck modelDuck=new ModelDuck();
        modelDuck.display();
        modelDuck.performFly();
        modelDuck.performQuack();
        modelDuck.setFlyBehavior(new FlyWithRocket());
        modelDuck.performFly();
    }
}
