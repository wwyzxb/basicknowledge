package designpartten.observe.jdk;

/**
 * @Author Vincent
 * @Date 2018/1/29 23:05
 */
public class WeatherStation {
    public static void main(String[] args){
        WeatherData weatherData=new WeatherData();
        CurrentConditionDisplay currentConditionDisplay=new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(23f,24f,12f);
    }
}
