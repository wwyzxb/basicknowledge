package javase.classinfo.proxy.jdk;

import javase.classinfo.proxy.base.Customer;
import javase.classinfo.proxy.base.MobileService;

import java.lang.reflect.Proxy;

/**
 * @author Vincent Wu
 * @datetime 2021/7/13 6:08
 */
public class JdkMobileServiceProxyTest {
    public static void main(String[] args) {
        Customer producer = new Customer();
        MobileService proxy = (MobileService) JdkProxyFactory.getProxy(producer);
        proxy.sendSms("Hello world!");

        MobileService proxy1 = (MobileService) Proxy.newProxyInstance(Customer.class.getClassLoader(), Customer.class.getInterfaces(), new MobileServiceHandler(producer));
        proxy1.sendSms("Hello world!");

    }
}
