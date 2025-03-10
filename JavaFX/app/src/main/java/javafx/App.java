package javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("JavaFX Window");
        //Dimensions of stage
        // stage.setWidth(800);
        // stage.setHeight(600);
        Group root = new Group();
        
        //Better way of setting size??
        Scene scene = new Scene(root, 600, 400, Color.BLACK);

        // Adding text
        Text text = new Text();
        text.setText("Hello World!");
        text.setX(50);
        text.setY(50);
        text.setFill(Color.WHITE);
        root.getChildren().add(text);


        stage.setScene(scene);
        //To show the window
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}