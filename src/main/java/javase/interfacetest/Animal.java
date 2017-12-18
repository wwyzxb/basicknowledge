package javase.interfacetest;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/18
 **/
public abstract class Animal implements Creature {
    @Override
    public void run() {
        //将有差异的方法放在子类中去实现，各个子类在自己的方法中实现自己的逻辑
        say();
    }

    //可以在抽象类中将一些子类的公用方法实现，多个子类只调用同一个方法即可
    @Override
    public void hehe() {
        System.out.println("hehehehehehe....");
    }
}
