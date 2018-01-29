package designpartten.observe.jdk;

import designpartten.observe.weather.DisplayMent;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author Vincent
 * @Date 2018/1/29 23:28
 */
public class CurrentConditionDisplay implements Observer,DisplayMent {
    private float temp;
    private float humidity;
    private Observable weatherData;

    public CurrentConditionDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData= (WeatherData) o;
            this.temp=weatherData.getTemp();
            this.humidity=weatherData.getHumidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current condition:" + temp + "F and humidity:" + humidity);
    }
}
