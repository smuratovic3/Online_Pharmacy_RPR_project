package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelpController {
    public Button btnClose;

    public void closeHelp(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnClose.getScene().getWindow();
        stage.close();
    }
}
