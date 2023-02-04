package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MedicineController {


    public TableView medicineTable;
    public TextField searchID;
    private final MedicineManager medicineManager = new MedicineManager();

    public void searchByText(ActionEvent actionEvent) {
        try {
            medicineTable.setItems(FXCollections.observableList(medicineManager.searchMedicine(searchID.getText())));
            medicineTable.refresh();
        } catch (MedicineException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
}
