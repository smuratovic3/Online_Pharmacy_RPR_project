package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class HomeController {


    public void actionLoginWindow(ActionEvent actionEvent) throws IOException
    {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            LoginController loginController = new LoginController();
            loader.setController(loginController);
            Parent root = loader.load();
            stage.setTitle("Login");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            //stage.setOnHiding();
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /*Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/login.fxml")));
        stage.setTitle("Log in");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

         */
    }

    public void actionRegisterWindow(ActionEvent actionEvent) throws IOException
    {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/registration.fxml"));
            RegistrationController registrationController = new RegistrationController();
            loader.setController(registrationController);
            Parent root = loader.load();
            stage.setTitle("Registration");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            //stage.setOnHiding();
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /*Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/registration.fxml")));
        stage.setTitle("Registration");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

         */
    }

    public void actionAboutUs(ActionEvent actionEvent) throws IOException
    {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/aboutus.fxml"));
            AboutUsController aboutUsController = new AboutUsController();
            loader.setController(aboutUsController);
            Parent root = loader.load();
            stage.setTitle("About us");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            //stage.setOnHiding();
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /*Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/aboutus.fxml")));
        stage.setTitle("About us");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

         */

    }

    public void helpAction(ActionEvent actionEvent) throws IOException
    {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/help.fxml"));
            HelpController helpController = new HelpController();
            loader.setController(helpController);
            Parent root = loader.load();
            stage.setTitle("Help");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            //stage.setOnHiding();
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /*Stage stage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/help.fxml")));
        stage.setTitle("Help");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

         */
    }
}
