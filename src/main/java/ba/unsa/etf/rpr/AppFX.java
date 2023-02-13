package ba.unsa.etf.rpr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class AppFX extends Application {
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
