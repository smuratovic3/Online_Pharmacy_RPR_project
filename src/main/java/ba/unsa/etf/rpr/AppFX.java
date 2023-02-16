package ba.unsa.etf.rpr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
        * AppFX class is responsible for loading and displaying the JavaFX UI using FXML.
        * @author Semina Muratovic
        * @version 1.0
        */

public class AppFX extends Application {

    /**
     * The `start` method is called when the Application is launched.
     * @param primaryStage The primary Stage of the Application.
     * @throws Exception if the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/pocetna.fxml")));
        primaryStage.setTitle("Online Pharmacy");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
