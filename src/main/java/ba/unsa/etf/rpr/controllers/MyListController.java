package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.IntermediateManager;
import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.domain.Medicine;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class MyListController {
    public Button btnClose;

    @FXML
    public TableView<Medicine> listTable;
    @FXML
    public TableColumn<Medicine, String> nameColumn = new TableColumn<>();
    @FXML
    public TableColumn<Medicine, String> priceColumn = new TableColumn<>();

    @FXML
    private final IntermediateManager intermediateManager = new IntermediateManager();




    public void actionClose(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnClose.getScene().getWindow();
        stage.close();
    }

}
