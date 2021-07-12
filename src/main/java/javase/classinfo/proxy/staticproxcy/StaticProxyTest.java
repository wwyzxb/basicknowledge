package javase.classinfo.proxy.staticproxcy;

import javase.classinfo.proxy.base.Customer;
import javase.classinfo.proxy.base.MobileService;

/**
 * @author Vincent Wu
 * @datetime 2021/7/13 5:53
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        MobileService customer = new Customer();
        MobileService proxy = new StaticMobileServiceProxy(customer);
        proxy.sendSms("Hello world!");
    }
}
