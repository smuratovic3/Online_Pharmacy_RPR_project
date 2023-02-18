package ba.unsa.etf.rpr;
import ba.unsa.etf.rpr.controllers.HomeController;
import ba.unsa.etf.rpr.controllers.MedicineController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/pocetna.fxml"));
            HomeController homeController = new HomeController();
            loader.setController(homeController);
            Parent root = loader.load();
            stage.setTitle("Online Pharmacy");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            //stage.setOnHiding();
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /*Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/pocetna.fxml")));
        primaryStage.setTitle("Online Pharmacy");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();

         */

    }
}
