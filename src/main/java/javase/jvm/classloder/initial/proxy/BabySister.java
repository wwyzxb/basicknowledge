package javase.jvm.classloder.initial.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/29
 **/
public class BabySister implements InvocationHandler{
    static {
        System.out.println("I am a baby sister...");
    }
    private Object proxied;

    public BabySister(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before feeding baby,bs will do something...");
        return method.invoke(proxied,args);
    }
}
