package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OnlineOrderController {
    public Button btnCancel;

    public void confirm(ActionEvent actionEvent) {
    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage =(Stage)btnCancel.getScene().getWindow();
        stage.close();
    }
}
