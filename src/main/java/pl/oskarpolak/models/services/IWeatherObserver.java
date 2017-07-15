package pl.oskarpolak.models.services;

/**
 * Created by Lenovo on 15.07.2017.
 */
public interface IWeatherObserver {
    void onWeatherUpdate(WeatherInfo weatherInfo);
}
