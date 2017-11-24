package guavaapi.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * @Author: wuxiaobing
 * @Date 2017/11/24
 **/
public class MainTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        CookieContaier cookieContainer = new CookieContaier(eventBus);
        HandlerService cookieSeller = new CookieSeller(eventBus);
        HandlerService cookieMailBoss = new CookieMailBoss(eventBus);

        //设置cookie的数量为3
        cookieContainer.setNumberOfCookie(3);
        //用户取三次之后cookie数量为空
        cookieContainer.getACookie();
        cookieContainer.getACookie();
        cookieContainer.getACookie();
        System.out.println("=======再次取cookie, 触发Empty事件发布============");
        cookieContainer.getACookie();
    }


}
