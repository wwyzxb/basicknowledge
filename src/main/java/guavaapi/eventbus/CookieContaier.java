package guavaapi.eventbus;

import com.google.common.eventbus.EventBus;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wuxiaobing
 * @Date 2017/11/24
 **/
public class CookieContaier {
    private EventBus eventBus;
    private AtomicInteger numberOfCookie = new AtomicInteger();

    public CookieContaier(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void setNumberOfCookie(Integer integer) {
        numberOfCookie.set(integer);
    }

    public void getACookie() {
        if (numberOfCookie.get() == 0) {
            long start = System.currentTimeMillis();
            /**
             * 使用post方法来发布事件
             */
            eventBus.post(new EmptyEvent());
            System.out.println("Publishing event times:" + (System.currentTimeMillis() - start) + "ms");
        }
        numberOfCookie.decrementAndGet();
        System.out.println("retrieve a cookie");
    }
}
