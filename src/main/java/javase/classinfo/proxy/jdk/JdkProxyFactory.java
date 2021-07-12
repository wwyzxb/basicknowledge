package javase.classinfo.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author Vincent Wu
 * @datetime 2021/7/13 6:05
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MobileServiceHandler(target));
    }
}
