package ba.unsa.etf.rpr;
import ba.unsa.etf.rpr.controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
public class AppFX extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/pocetna.fxml"));
        Pane root = new Pane();
        root.setPrefSize(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        root.getChildren().add(fxmlLoader.load());

        // Set the background image
        /*Image image = new Image(getClass().getResourceAsStream("/images/image.jpg"));
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        root.setBackground(new Background(backgroundImage));*/

        primaryStage.setTitle("Pocetna");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    public static void main( String[] args )
    {
        launch(args);
    }
}