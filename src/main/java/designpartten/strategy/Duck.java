package designpartten.strategy;

import designpartten.strategy.fly.FlyBehavior;
import designpartten.strategy.quack.QuackBehavior;

/**
 * @Author Vincent
 * @Date 2018/1/23 22:59
 */
public abstract class Duck {
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
