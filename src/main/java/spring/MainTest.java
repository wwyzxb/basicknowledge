package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: wuxiaobing
 * @Date 2018/3/2
 **/
public class MainTest {
    public static void main(String[] args){
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Car car= (Car) context.getBean("car");
    }
}
