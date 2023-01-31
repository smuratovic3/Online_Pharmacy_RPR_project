package ba.unsa.etf.rpr.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    public Button btnCancel;
    public TextField idEmail;
    public PasswordField idPassword;

    @FXML
    public void initialize(){
        idEmail.getStyleClass().add("poljeNijeIspravno");
        idEmail.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(idEmail.getText().trim().isEmpty()){
                    idEmail.getStyleClass().removeAll("poljeJeIspravno");
                    idEmail.getStyleClass().add("poljeNijeIspravno");
                }else{
                    idEmail.getStyleClass().removeAll("poljeNijeIspravno");
                    idEmail.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
    }

    public void actionSubmit(ActionEvent actionEvent) throws IOException {


        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/medicine.fxml"));
        stage.setTitle("Home page");
        stage.setScene(new Scene(root, 600,550));
        stage.setResizable(false);
        stage.show();

    }

    public void actionClose(ActionEvent actionEvent) {
        Stage stage =(Stage)btnCancel.getScene().getWindow();
        stage.close();
    }
}
