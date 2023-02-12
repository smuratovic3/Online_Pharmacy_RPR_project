package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public class MedicineController {
    @FXML
    public TableView<Medicine> medicineTable;
    public ObservableList<Medicine> lista = FXCollections.observableArrayList();
    public TextField searchText;
    private final MedicineManager medicineManager = new MedicineManager();
    private final UserManager  userManager = new UserManager();




    @FXML
     public TableColumn<Medicine, String> nameColumn  = new TableColumn<>();
    @FXML
    public TableColumn<Medicine, Integer> priceColumn  = new TableColumn<>();
    @FXML
     public TableColumn<Medicine, Integer>  quantityColumn  = new TableColumn<>();
    @FXML
     public TableColumn<Medicine, String>  descriptionColumn  = new TableColumn<>();
    @FXML
    public TableColumn<Medicine, Integer> orderColumn;



    @FXML
    public void initialize()
{
         nameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
         priceColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("price"));
         quantityColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("quantity"));
         descriptionColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("description"));
         /*orderColumn.setCellFactory(new ButtonCellFactory(editEvent -> {
        int trainId = Integer.parseInt(((Button)editEvent.getSource()).getUserData().toString());
        viewButtonOnAction(trainId);
    }));*/
    class OrderCell extends TableCell<Medicine, Integer> {
        private Button btn = new Button("Order");
        public OrderCell() {
            btn.setOnAction(event -> {
                Medicine medicine = getTableView().getItems().get(getIndex());
                // Add your logic here to handle the button click event
            });
        }
        @Override
        protected void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
            } else {
                setGraphic(btn);
            }
        }
    }
    orderColumn.setCellFactory(column -> new OrderCell());



    refreshMedicine();
}

    private void viewButtonOnAction(int trainId) {
        
    }

    void refreshMedicine() {
        try {
            medicineTable.setItems(FXCollections.observableList(medicineManager.getAll()));
            medicineTable.refresh();
        } catch (MedicineException e) {
            e.printStackTrace();
        }
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
