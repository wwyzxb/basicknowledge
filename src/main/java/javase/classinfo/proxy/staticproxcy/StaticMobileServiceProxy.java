package javase.classinfo.proxy.staticproxcy;

import javase.classinfo.proxy.base.MobileService;

/**
 * @author Vincent Wu
 * @datetime 2021/7/13 5:49
 */
public class StaticMobileServiceProxy implements MobileService {
    MobileService mobileService;

    public StaticMobileServiceProxy(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @Override
    public void sendSms(String msg) {
        System.out.println("Before send msg: I am StaticMobileServiceProxy!");
        mobileService.sendSms(msg);
        System.out.println("After send msg: I am StaticMobileServiceProxy!");
    }
}
