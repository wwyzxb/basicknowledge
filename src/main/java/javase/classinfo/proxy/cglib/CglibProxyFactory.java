package javase.classinfo.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author Vincent Wu
 * @datetime 2021/7/13 6:34
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MobileServiceInterceptor());
        return enhancer.create();

    }
}
