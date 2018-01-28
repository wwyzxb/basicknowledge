package designpartten.observe.myself;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Vincent
 * @Date 2018/1/28 23:53
 */
public class ConcreteSubject implements Subject {
    List<Observer> observersList = new ArrayList<>();

    @Override
    public void register(Observer obj) {
        observersList.add(obj);
    }

    @Override
    public void remove(Observer obj) {
        observersList.remove(obj);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observersList) {
            observer.update(getTemperature(),getHumidity(),getPressure());
        }
    }

    public float getTemperature(){
        return 23.8f;
    }
    public float getHumidity(){
        return 678.0f;
    }
    public float getPressure(){
        return 90.0f;
    }
}

