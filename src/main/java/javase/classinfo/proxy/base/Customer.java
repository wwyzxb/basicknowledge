package javase.classinfo.proxy.base;

/**
 * @author Vincent Wu
 * @datetime 2021/7/13 5:50
 */
public class Customer implements MobileService {
    @Override
    public void sendSms(String msg) {
        System.out.println(String.format("I am SmsProducer! Sending sms: [%s] ", msg));
    }
}
