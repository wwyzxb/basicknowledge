package javase.jvm.classloder.initial.proxy;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/29
 **/
public class Parent implements CareBaby{
    static {
        System.out.println("I am parent");
    }
    @Override
    public void feed() {
        System.out.println("feed baby...");
    }
}
