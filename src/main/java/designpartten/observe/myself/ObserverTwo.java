package designpartten.observe.myself;

/**
 * @Author Vincent
 * @Date 2018/1/29 0:05
 */
public class ObserverTwo implements Observer  {
    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("ObserverTwo："+temp+"--"+humidity+"--"+pressure);
    }
}
