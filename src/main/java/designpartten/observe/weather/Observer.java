package designpartten.observe.weather;

/**
 * @Author Vincent
 * @Date 2018/1/28 23:52
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
