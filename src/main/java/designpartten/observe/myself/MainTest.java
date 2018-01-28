package designpartten.observe.myself;

/**
 * @Author Vincent
 * @Date 2018/1/29 0:08
 */
public class MainTest {
    public static void main(String[] args) {
        Subject concreteSubject = new ConcreteSubject();
        Observer one=new ObserverOne();
        Observer two=new ObserverTwo();
        Observer three=new ObserverThree();
        concreteSubject.register(one);
        concreteSubject.register(two);
        concreteSubject.register(three);
        concreteSubject.notifyObserver();
        System.out.println("------");
        concreteSubject.remove(two);
        concreteSubject.notifyObserver();

    }
}
