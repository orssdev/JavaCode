package dev.orss.weather;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application
{
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Weather");
        Image icon = new Image(getClass().getResourceAsStream("/images/weather-app.png"));
        stage.getIcons().add(icon);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Main.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args); 
    }
}
