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
    public TextField nameField;
    public TextField surnameField;
    public TextField addressField;

    public TextField phoneField;

    UserManager userManager = new UserManager();

    /**
     Initializes the form by adding event listeners to the form fields.
     */


    public void actionSubmit(ActionEvent actionEvent) throws IOException, MedicineException {

        //Retrieve user input form form field
        String nameInput = nameField.getText();
        String surnameInput = surnameField.getText();
        String addressInput = addressField.getText();
        String phoneInput = phoneField.getText();
        String emailInput = emailField.getText();
        String passwordInput = passwordField.getText();
        boolean check = false;

        // Validate the input
        if (Objects.equals(nameField.getText(), "")) {
            // Display an error message
            messageLabel1.setText("Name can't be empty.");
            check = true;
        }
        if (Objects.equals(surnameField.getText(), "")) {
            // Display an error message
            messageLabel1.setText("Surname can't be empty.");
            check = true;
        }
        if (Objects.equals(addressField.getText(), "")) {
            // Display an error message
            messageLabel1.setText("Address can't be empty.");
            check = true;
        }
        if (Objects.equals(phoneField.getText(), "")) {
            // Display an error message
            messageLabel1.setText("Phone number can't be empty.");
            check = true;
        }

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
            user.setName(nameInput);
            user.setSurname(surnameInput);
            user.setAddress(addressInput);
            user.setPhone(Integer.parseInt(phoneInput));
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
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Clear the error message when the name field is changed
            messageLabel1.setText("");
        });

        // Add an event listener to the surname field
        surnameField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Clear the error message when the surname field is changed
            messageLabel1.setText("");
        });

        // Add an event listener to the address field
        addressField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Clear the error message when the username field is changed
            messageLabel1.setText("");
        });
        // Add an event listener to the phone number field
        phoneField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Clear the error message when the username field is changed
            messageLabel1.setText("");
        });

        // Add an event listener to the email field
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Clear the error message when the name field is changed
            messageLabel1.setText("");
        });

        // Add an event listener to the password field
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Clear the error message when the password field is changed
            messageLabel2.setText("");
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


