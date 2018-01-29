package designpartten.observe.weather.impl;

import designpartten.observe.weather.Observer;
import designpartten.observe.weather.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Vincent
 * @Date 2018/1/29 22:52
 */
public class WeatherData implements Subject {
    private float temp;
    private float humidity;
    private float pressure;

    private List<Observer> observerList;

    public WeatherData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observerList.add(obj);
    }

    @Override
    public void remove(Observer obj) {
        observerList.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temp, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
