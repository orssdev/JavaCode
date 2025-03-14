package dev.orss.weather;

import org.checkerframework.checker.units.qual.h;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller 
{
    @FXML private Button searchButton;
    @FXML private Label locationLabel;
    @FXML private Label tempLabel;
    @FXML private Label humidityLabel;
    @FXML private Label windSpeedLabel;
    @FXML private TextField inputText;
    @FXML private ImageView conditionImage;
    private Weather weather;
    private JSONObject weatherObject;

    public void searchAction(ActionEvent e) throws Exception
    {
        weather = new Weather();
        weather.setLocation(inputText.getText());
        String response = weather.request();
        weatherObject = new JSONObject(response);
        int code = weatherObject.getInt("cod");
        if(code == 200)
        {
            code200();
        }
        else
        {
            code400();
        }
    }

    public void code400()
    {
        locationLabel.setText("city not found");
        tempLabel.setText("-- °F");
        humidityLabel.setText("-- %");
        windSpeedLabel.setText("-- mph");
        conditionImage.setImage(new Image(getClass().getResourceAsStream("/images/weather-app.png")));
    }

    public void code200()
    {
        JSONObject main = weatherObject.getJSONObject("main");
        locationLabel.setText(weatherObject.getString("name"));
        tempLabel.setText(String.format("%d °F", Math.round(main.getDouble("temp"))));
        humidityLabel.setText(String.format("%.2f %%", main.getDouble("humidity")));
        windSpeedLabel.setText(String.format("%.2f mph", weatherObject.getJSONObject("wind").getDouble("speed")));
        conditionImage.setImage(new Image(String.format("https://openweathermap.org/img/wn/%s@4x.png", weatherObject.getJSONArray("weather").getJSONObject(0).getString("icon"))));
    }
}
