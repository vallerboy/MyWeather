package pl.oskarpolak.models.services;

import org.json.JSONObject;
import pl.oskarpolak.models.Config;
import pl.oskarpolak.models.Utils;

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

    //Dane z API
    private double temp;

    private WeatherService() {

    }

    public void makeCall(String city, String country){
        appurl = Config.APPURL + "weather" + "?q=" + city + "," + country + "&appid=" + Config.APPID;
        Utils.connectAndResponse(appurl);
    }

    private void parseJsonData(String data){
        JSONObject rootObject = new JSONObject(data);
        JSONObject mainObject = rootObject.getJSONObject("main");

        temp = mainObject.getDouble("temp");
    }
}
