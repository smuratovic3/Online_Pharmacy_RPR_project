package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyListController {
    public Button btnClose;

    public void actionClose(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnClose.getScene().getWindow();
        stage.close();
    }
}
