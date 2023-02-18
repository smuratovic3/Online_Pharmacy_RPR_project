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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {
    @FXML
    public Label badEmailIN;
    @FXML
    public Label badPasswordIN;
    @FXML
    public Label errorLabel;
    public Button btnCancel;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    UserManager userManager = new UserManager();
    private int id;


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


    public void actionClose(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void actionSubmit() throws MedicineException{

        List<User> listaUsera = userManager.getAll();

        //Establish a connection to the database
        boolean loginSuccessful = false;
        User user = new User();
        //System.out.println(" " + loginSuccessful + " ");

        //Validate the input
        if (emailField.getText().isEmpty()) {
            //display an error message
            badEmailIN.setText("Email cannot be empty!");

        } else badEmailIN.setText("");

        if (passwordField.getText().isEmpty()) {
            //display an error message
            badPasswordIN.setText("Password cannot be empty!");

        } else {
            badPasswordIN.setText("");
        }

        if (!emailField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
            for (User u : listaUsera) {
                if (u.getEmail().equals(emailField.getText()) && u.getPassword().equals(passwordField.getText())) {
                    loginSuccessful = true;
                    id = u.getId();
                }
            }
        }

        if (loginSuccessful) {

            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/medicine.fxml"));
                MedicineController medicineController = new MedicineController(id);
                //System.out.println("Ušao je" + " " + id);
                loader.setController(medicineController);
                Parent root = loader.load();
                stage.setTitle("Medicine");
                stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                stage.setResizable(false);
                //stage.setOnHiding();
                stage.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            errorLabel.setText("Invalid login. Try again!");

        }
    }}


