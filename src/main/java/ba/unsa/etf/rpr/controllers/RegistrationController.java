package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class RegistrationController {
    public Button btnCancel;
    public Label messageLabel1;
    public TextField emailField;
    public Label messageLabel4;
    public Label messageLabel2;
    UserManager userManager = new UserManager();

    public void actionSubmit(ActionEvent actionEvent) throws IOException, MedicineException {
        List<User> listaUsera = userManager.getAll();

        //Establish a connection to the database
        boolean registrationSuccessful = false;
        User user = new User();

        //Validate the input
        if (emailField.getText().isEmpty()) {
            //display an error message
            messageLabel1.setText("Email cannot be empty!");
        } else {
            messageLabel1.setText("");
            user.setEmail(emailField.getText());



            //Add the user to the database
            userManager.add(user);

            //Set the registrationSuccessful flag to true
            registrationSuccessful = true;
        }

        if (registrationSuccessful) {
            try {
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/medicine.fxml")));
                stage.setTitle("Medicine");
                stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            //Display a confirmation message
            messageLabel2.setText("You have been successfully registered!");
        } else {
            messageLabel4.setText("Invalid registration. Try again!");
        }
    }



    public void actionClose(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnCancel.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void initialize()
    {
        emailField.getStyleClass().add("poljeNijeIspravno");
        emailField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(emailField.getText().trim().isEmpty()){
                    emailField.getStyleClass().removeAll("poljeJeIspravno");
                    emailField.getStyleClass().add("poljeNijeIspravno");
                }else{
                    emailField.getStyleClass().removeAll("poljeNijeIspravno");
                    emailField.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
    }


}


