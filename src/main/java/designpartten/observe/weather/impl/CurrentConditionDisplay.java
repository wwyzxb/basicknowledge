package designpartten.observe.weather.impl;

import designpartten.observe.weather.DisplayMent;
import designpartten.observe.weather.Observer;
import designpartten.observe.weather.Subject;

/**
 * @Author Vincent
 * @Date 2018/1/29 23:00
 */
public class CurrentConditionDisplay implements Observer, DisplayMent {
    private float temp;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject subject) {
        this.weatherData = subject;
        weatherData.register(this);
    }

    @Override
    public void display() {
        System.out.println("Current condition:" + temp + "F and humidity:" + humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        display();
    }
}
