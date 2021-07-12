package javase.classinfo.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Vincent Wu
 * @datetime 2021/7/13 6:30
 */
public class MobileServiceInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before " + method.getName() + " : I am MobileServiceInterceptor!");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("After " + method.getName() + " : I am MobileServiceInterceptor!");
        return result;
    }
}
