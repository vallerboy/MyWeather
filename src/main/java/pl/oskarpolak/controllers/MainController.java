package pl.oskarpolak.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    @FXML
    ProgressIndicator progressBar;

    private WeatherService weatherService = WeatherService.getService();


    public void initialize(URL location, ResourceBundle resources) {
        weatherService.addWeatherObserver(this);
        progressBar.setVisible(false);

        buttonShowWeather.setOnMouseClicked(e -> {
            if(!weatherCity.getText().isEmpty() && weatherCity.getText().length() > 3) {
                progressBar.setVisible(true);
                weatherService.makeCall(weatherCity.getText(), "pl");
            }else{
                //TODO add this to Utils class
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Błąd");
                alert.setContentText("Nieprawidłowa nazwa miasta");
                alert.show();
            }
        });

    }

    @Override
    public void onWeatherUpdate(WeatherInfo weatherInfo) {
        textWeather.setText("Temperatura: " + weatherInfo.getTemperatureCelsius() + "\n"
                 + "Wilgotność: " + weatherInfo.getHumidity() + "\n"
                 + "Ciśnenie: " + weatherInfo.getPressure() + "\n"
                 + "Zachmurzenie: " + weatherInfo.getCloudy()
        );
        progressBar.setVisible(false);
    }
}
