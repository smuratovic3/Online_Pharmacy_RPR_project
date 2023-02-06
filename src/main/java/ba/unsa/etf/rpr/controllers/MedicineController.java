package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;


public class MedicineController {

    public TableView medicineTable;
    public TextField searchText;
    private final MedicineManager medicineManager = new MedicineManager();


    public TableColumn<Medicine, Integer> idColumn;
     public TableColumn<Medicine, String> nameColumn;
     public TableColumn<Medicine, Integer>  quantityColumn;
     public TableColumn<Medicine, String>  descriptionColumn;


    /* public void initialize() {
         idColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("id"));
         nameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
         quantityColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("quantity"));
         descriptionColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("description"));


     }*/
    public void searchByText(ActionEvent actionEvent) {
        try {
            medicineTable.setItems(FXCollections.observableList(medicineManager.searchMedicine(searchText.getText())));
            medicineTable.refresh();
        } catch (MedicineException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
}
