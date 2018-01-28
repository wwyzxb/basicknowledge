package designpartten.observe.myself;

/**
 * @Author Vincent
 * @Date 2018/1/28 23:50
 */
public interface Subject {
    public void register(Observer obj);
    public void remove(Observer obj);
    public void notifyObserver();
}
