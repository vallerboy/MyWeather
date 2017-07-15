package pl.oskarpolak.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    Button buttonShowWeather;


    public void initialize(URL location, ResourceBundle resources) {
        buttonShowWeather.setOnMouseClicked(e -> System.out.println("Hejo!"));
    }
}
