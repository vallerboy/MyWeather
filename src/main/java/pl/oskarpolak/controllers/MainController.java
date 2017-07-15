package pl.oskarpolak.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import pl.oskarpolak.models.services.IWeatherObserver;
import pl.oskarpolak.models.services.WeatherInfo;
import pl.oskarpolak.models.services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, IWeatherObserver{

    @FXML
    private Button buttonShowWeather;

    private WeatherService weatherService = WeatherService.getService();


    public void initialize(URL location, ResourceBundle resources) {
        weatherService.addWeatherObserver(this);

        buttonShowWeather.setOnMouseClicked(e -> {
            weatherService.makeCall("Cracow", "pl");

        });
    }

    @Override
    public void onWeatherUpdate(WeatherInfo weatherInfo) {
        System.out.println("Temperatura z onWeatherUpdate: " + weatherInfo.getTemperatureCelsius());
    }
}
