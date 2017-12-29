package javase.jvm.classloder.initial.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/29
 **/
public class MainClass {
    public static void main(String[] args){
        CareBaby parentCare=new Parent();
        BabySister bsCare=new BabySister(parentCare);
        CareBaby finalCare= (CareBaby) Proxy.newProxyInstance(CareBaby.class.getClassLoader(),new Class[]{CareBaby.class},bsCare);
        finalCare.feed();
    }
}
