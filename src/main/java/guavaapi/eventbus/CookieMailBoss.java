package guavaapi.eventbus;

import com.google.common.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

/**
 * CookieMailBoss为另一个消息订阅者
 *
 * @Author: wuxiaobing
 * @Date 2017/11/24
 **/
public class CookieMailBoss implements HandlerService {
    public CookieMailBoss(EventBus eventBus) {
        /**
         * 使用register方法来注册订阅者
         */
        eventBus.register(this);
    }

    public void handler(EmptyEvent emptyEvent) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getClass().getSimpleName() + ":" + "receiving empty event");
    }
}
