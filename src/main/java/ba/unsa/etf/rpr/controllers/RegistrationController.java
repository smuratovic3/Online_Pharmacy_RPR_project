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

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.regex.Pattern;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class RegistrationController {
    public Button btnCancel;
    public Label messageLabel1;
    public TextField emailField;
    public PasswordField passwordField;
    public Label messageLabel2;

    UserManager userManager = new UserManager();

    /**
     Initializes the form by adding event listeners to the form fields.
     */


    public void actionSubmit(ActionEvent actionEvent) throws IOException, MedicineException {

        //Retrieve user input form form field
        String emailInput = emailField.getText();
        String passwordInput = passwordField.getText();
        boolean check = false;


        //validate the input
        if (Objects.equals(emailField.getText(), "")) {
            // Display an error message
            messageLabel1.setText("Email can't be empty.");
            check = true;
        }
        if (Objects.equals(passwordField.getText(), "")) {
            // Display an error message
            messageLabel2.setText("Password can't be empty");
            check = true;
        }else {
            // Use a regular expression to check the email format
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            if (!pattern.matcher(emailInput).matches()) {
                // Display an error message
                messageLabel1.setText("Invalid email format.");
                check = true;
            }
        }
        if (!check) {
            // Create a new user data object and set the instance variables
            User user = new User();
            user.setEmail(emailInput);
            user.setPassword(passwordInput);

            try {
                FileReader reader = new FileReader("src/main/resources/database.properties");
                Properties p = new Properties();
                p.load(reader);
                String s1 = p.getProperty("db.username"), s2 = p.getProperty("db.password"), s3 = p.getProperty("db.server");
                Connection connection = DriverManager.getConnection(s3, s1, s2);
                System.out.println(s1 + " " + s2 + " " + s3);

                // Add the new user to the database
                User insertedUser = userManager.add(user);

                // Check if the user object was returned by the add User method from UserDaoSQLImpl.java
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/medicine.fxml"));
                stage.setTitle("Home page");
                stage.setScene(new Scene(root, USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
                stage.setResizable(false);
                stage.show();

                // Close the connection to the database
                connection.close();

            } catch (Exception exc) {
                exc.printStackTrace();
            }
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
        // Add an event listener to the name field
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Clear the error message when the name field is changed
            messageLabel1.setText("");
        });

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


