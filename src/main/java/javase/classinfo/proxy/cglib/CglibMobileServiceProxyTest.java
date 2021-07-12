package javase.classinfo.proxy.cglib;

import javase.classinfo.proxy.base.Customer;

/**
 * @author Vincent Wu
 * @datetime 2021/7/13 6:33
 */
public class CglibMobileServiceProxyTest {
    public static void main(String[] args) {
        Customer customer = (Customer) CglibProxyFactory.getProxy(Customer.class);
        customer.sendSms("Hello world!");
    }
}
