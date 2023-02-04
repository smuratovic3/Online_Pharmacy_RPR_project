package ba.unsa.etf.rpr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AppFX extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/pocetna.fxml"));
        primaryStage.setTitle("Online Pharmacy");
        primaryStage.setScene(new Scene(root, 580, 400));
        primaryStage.setResizable(false);
        primaryStage.show();

    }public static void main( String[] args )
    {
        launch(args);
    }
}