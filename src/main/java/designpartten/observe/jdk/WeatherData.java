package designpartten.observe.jdk;

import java.util.Observable;

/**
 * @Author Vincent
 * @Date 2018/1/29 23:25
 */
public class WeatherData extends Observable {
    private float temp;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
       // setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemp() {
        return temp;
    }


    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}
