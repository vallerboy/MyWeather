package pl.oskarpolak.models.services;

import org.json.JSONObject;
import pl.oskarpolak.models.Config;
import pl.oskarpolak.models.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 15.07.2017.
 */
public class WeatherService {
    private static WeatherService ourInstance = new WeatherService();

    public static WeatherService getService() {
        return ourInstance;
    }

    // Dane API
    private String appurl;
    private String cityName;

    //Dane z API
    private double temp;
    private int humidity;
    private int pressure;
    private int cloudy;

    //Observer pattern
    List<IWeatherObserver> observerList = new ArrayList<>();

    private WeatherService() {

    }

    public void makeCall(String city, String country){
        appurl = Config.APPURL + "weather" + "?q=" + city + "," + country + "&appid=" + Config.APPID;
        cityName = city;
        parseJsonData(Utils.connectAndResponse(appurl));
    }

    private void parseJsonData(String data){
        JSONObject rootObject = new JSONObject(data);
        JSONObject mainObject = rootObject.getJSONObject("main");

        temp = mainObject.getDouble("temp");
        humidity = mainObject.getInt("humidity");
        pressure = mainObject.getInt("pressure");

        JSONObject cloudsObject = rootObject.getJSONObject("clouds");
        cloudy = cloudsObject.getInt("all");

        informObservers();
    }

    public void addWeatherObserver(IWeatherObserver observer){
        observerList.add(observer);
    }

    public void removeWeatherObserver(IWeatherObserver observer){
        observerList.remove(observer);
    }

    private void informObservers(){
        WeatherInfo weatherInfo = new WeatherInfo(temp, humidity, pressure, cloudy, cityName);
        observerList.forEach(s -> {
             s.onWeatherUpdate(weatherInfo);
        });
    }
}
