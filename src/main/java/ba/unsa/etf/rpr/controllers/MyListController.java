package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.IntermediateManager;
import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.business.OnlineOrderManager;
import ba.unsa.etf.rpr.domain.IntermediateTable;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.domain.OnlineOrder;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MyListController {
    public Button btnClose;
    @FXML
    public TableView<Medicine> listTable;
    @FXML
    public TableColumn<Medicine, String> nameColumn = new TableColumn<>();

    @FXML
    private final IntermediateManager intermediateManager = new IntermediateManager();
    private final MedicineManager medicineManager = new MedicineManager();





    public void initialize(){
        Model model = Model.getInstance();

         nameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));

        refreshMedicines();
    }

    void refreshMedicines() {
        try {
            Model model = Model.getInstance();
            listTable.setItems(FXCollections.observableList(intermediateManager.getByUser(model.getUser().getId())));
            listTable.refresh();
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    /*void refreshMedicine() {
        try {
            listTable.setItems(FXCollections.observableList(medicineManager.getAll()));
            listTable.refresh();
        } catch (MedicineException e) {
            e.printStackTrace();
        }
    }
*/
    public void actionClose(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnClose.getScene().getWindow();
        stage.close();
    }
}
