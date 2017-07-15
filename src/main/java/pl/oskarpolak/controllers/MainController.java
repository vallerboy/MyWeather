package pl.oskarpolak.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import pl.oskarpolak.models.services.WeatherService;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    private Button buttonShowWeather;

    private WeatherService weatherService = WeatherService.getService();


    public void initialize(URL location, ResourceBundle resources) {
        buttonShowWeather.setOnMouseClicked(e -> {
            weatherService.makeCall("Cracow", "pl");
            System.out.println("Temperatura: " + weatherService.getTemperature());
        });


    }
}
