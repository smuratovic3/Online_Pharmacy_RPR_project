package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public class MedicineController {

    public TableView<Medicine> medicineTable;
    public ObservableList<Medicine> lista = FXCollections.observableArrayList();
    public TextField searchText;
    private final MedicineManager medicineManager = new MedicineManager();



     public TableColumn<Medicine, String> nameColumn  = new TableColumn<>();
    public TableColumn<Medicine, Integer> priceColumn  = new TableColumn<>();
     public TableColumn<Medicine, Integer>  quantityColumn  = new TableColumn<>();
     public TableColumn<Medicine, String>  descriptionColumn  = new TableColumn<>();

@FXML
    public void initialize()
{
         nameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
         priceColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("price"));
         quantityColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("quantity"));
         descriptionColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("description"));

}
    public void searchByText(ActionEvent actionEvent)
    {
        try {
            List<Medicine> lista =medicineManager.searchMedicine(searchText.getText());
            if(lista.size() > 0){
                System.out.println(lista.get(0).getName() + " " + lista.get(0).getDescription());
            }
            medicineTable.setItems(FXCollections.observableList(lista));
        } catch (MedicineException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
}
