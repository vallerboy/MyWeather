package pl.oskarpolak.models.services;

import pl.oskarpolak.models.Utils;

/**
 * Created by Lenovo on 15.07.2017.
 */
public class WeatherInfo {
    private double temp;
    private int humidity;
    private int pressure;
    private int cloudy;

    public WeatherInfo(double temp, int humidity, int pressure, int cloudy) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.cloudy = cloudy;
    }

    public WeatherInfo() { }

    public double getTemperatureKelvin(){
        return temp;
    }

    public double getTemperatureCelsius(){
        return Utils.kelvinToCelsius(temp);
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getCloudy() {
        return cloudy;
    }

    public void setCloudy(int cloudy) {
        this.cloudy = cloudy;
    }
}
