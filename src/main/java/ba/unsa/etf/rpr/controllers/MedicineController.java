package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MedicineController {


    public TableView medicineTable;
    private final MedicineManager medicineManager = new MedicineManager();
    public TextField searchText;

    /*public TableColumn<Medicine, Integer> id;
     public TableColumn<Medicine, String> name;
     public TableColumn<Medicine, Integer>  quantity;
     public TableColumn<Medicine, String>  description;


     public void initialize() {
         id.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("id"));
         name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("medicine_Name"));
         quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("medicine_Quantity"));
         description.setCellValueFactory(new PropertyValueFactory<Medicine, String>("medicine_Description"));


     }
*/
    public void searchByText(ActionEvent actionEvent) {
        try {
            medicineTable.setItems(FXCollections.observableList(medicineManager.searchMedicine(searchText.getText())));
            medicineTable.refresh();
        } catch (MedicineException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
}
