package javase.classinfo.reflect;//: typeinfo/SimpleDynamicProxy.java

import java.lang.reflect.*;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * 在方法执行之前做一些额外的操作
         */
        if ("doSomething".equals(method.getName())) {
            System.out.println("do something before function doSomething executing");
        }
        if ("somethingElse".equals(method.getName())) {
            args[0]="hahahaha";
            System.out.println("do something before function somethingElse executing");
        }
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        System.out.println("*********动态代理*********");
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}