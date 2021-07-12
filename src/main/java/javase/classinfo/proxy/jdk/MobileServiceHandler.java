package javase.classinfo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Vincent Wu
 * @datetime 2021/7/13 6:01
 */
public class MobileServiceHandler implements InvocationHandler {
    private final Object target;

    public MobileServiceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before " + method.getName() + " : I am MobileServiceHandler!");
        Object result = method.invoke(target, args);
        System.out.println("After " + method.getName() + " : I am MobileServiceHandler!");
        return result;
    }
}
