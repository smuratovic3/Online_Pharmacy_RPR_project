package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AboutUsController {
    public Button btnClose;

    public void closeAboutUs(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnClose.getScene().getWindow();
        stage.close();
    }
}
