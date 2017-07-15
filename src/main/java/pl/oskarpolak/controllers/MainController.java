package pl.oskarpolak.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pl.oskarpolak.models.services.IWeatherObserver;
import pl.oskarpolak.models.services.WeatherInfo;
import pl.oskarpolak.models.services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, IWeatherObserver{

    @FXML
    private Button buttonShowWeather;

    @FXML
    private Label textWeather;

    @FXML
    private TextField  weatherCity;

    private WeatherService weatherService = WeatherService.getService();


    public void initialize(URL location, ResourceBundle resources) {
        weatherService.addWeatherObserver(this);

        buttonShowWeather.setOnMouseClicked(e -> {
            if(!weatherCity.getText().isEmpty() && weatherCity.getText().length() > 3) {
                weatherService.makeCall(weatherCity.getText(), "pl");
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Błąd");
                alert.setContentText("Nieprawidłowa nazwa miasta");
            }
        });

    }

    @Override
    public void onWeatherUpdate(WeatherInfo weatherInfo) {
        System.out.println("Temperatura z " + weatherInfo.getCityName() + ": " + weatherInfo.getTemperatureCelsius());
    }
}
