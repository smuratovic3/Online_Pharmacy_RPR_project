package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    public void actionLoginWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("Log in");
        stage.setScene(new Scene(root, 580,400));
        stage.setResizable(false);
        stage.show();
    }


    public void actionRegisterWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/registration.fxml"));
        stage.setTitle("Log in");
        stage.setScene(new Scene(root, 580,400));
        stage.setResizable(false);
        stage.show();
    }
}
