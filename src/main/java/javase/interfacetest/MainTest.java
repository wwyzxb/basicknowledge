package javase.interfacetest;

/**
 * @Author: wuxiaobing
 * @Date 2017/12/18
 **/
public class MainTest {
    public static void main(String[] args){
        Creature creature1=new Bird();
        creature1.run();
        creature1.hehe();
        Creature creature2=new Tiger();
        creature2.run();
        creature2.hehe();
    }
}
