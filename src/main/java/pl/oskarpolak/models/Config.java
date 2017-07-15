package pl.oskarpolak.models;

/**
 * Created by Lenovo on 15.07.2017.
 */
public class Config {
    public static final String APPID = "ef2028e98b54649bf1f4c4582631f350"; // Klucz do API z openweathermap

    //W przyszłości stworzymy sobie buildera urla API, żeby ładnie nam się to komponowało, na ten moment
    //korzystamy z konkatenacji
    public static final String APPURL = "http://api.openweathermap.org/data/2.5/"; // URL do API z openweathermap
}
