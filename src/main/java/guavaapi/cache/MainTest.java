package guavaapi.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        GuavaCache2 guavaCache2 = (GuavaCache2) ac.getBean("guavaCache2");
        guavaCache2.init();
        guavaCache2.testDateNoneCache();
        guavaCache2.testDataCache();
    }
}
