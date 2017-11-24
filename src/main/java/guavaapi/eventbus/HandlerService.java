package guavaapi.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: wuxiaobing
 * @Date 2017/11/24
 **/
public interface HandlerService {
    /**
     * Subscribe对象需要定义handler method，用于接受并处理一个通知事件的对象
     * <p>
     * 如果你需要订阅某种类型的消息,使用@Subscribe标签标识
     */
    @Subscribe
    void handler(EmptyEvent emptyEvent);
}
