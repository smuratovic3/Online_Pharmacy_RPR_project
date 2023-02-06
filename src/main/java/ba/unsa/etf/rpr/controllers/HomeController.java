package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class HomeController {
    @FXML
    public Label badUsernameIN;
    @FXML
    public Label badPasswordIN;
    @FXML
    public Label errorLabel;
    private UserManager u = new UserManager();

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
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

    }

    public void actionClose(ActionEvent actionEvent) {
        Stage stage =(Stage)btnCancel.getScene().getWindow();
        stage.close();
    }
}
