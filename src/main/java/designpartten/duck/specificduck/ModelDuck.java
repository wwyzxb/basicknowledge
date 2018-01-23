package designpartten.duck.specificduck;

import designpartten.duck.Duck;
import designpartten.duck.fly.FlyNoWay;
import designpartten.duck.fly.FlyWithRocket;
import designpartten.duck.quack.MuteQuack;
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
