package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class MedicineController {

    @FXML
    public TableView<Medicine> medicineTable;
    public ObservableList<Medicine> lista = FXCollections.observableArrayList();
    public TextField searchText;
    private final MedicineManager medicineManager = new MedicineManager();
    private final CategoryManager categoryManager = new CategoryManager();

    public static Medicine medicine = new Medicine();

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
    private int loggedUserId;

    public MedicineController() {
    }

    public MedicineController(int loggedUserId) {
        this.loggedUserId = loggedUserId;
    }

    @FXML
    public void initialize()
{
         nameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
         priceColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("price"));
         quantityColumn.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("quantity"));
         descriptionColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("description"));
        class OrderCell extends TableCell<Medicine, Integer> {
        private Button btn = new Button("Order");

        public OrderCell() {
            btn.setOnAction(event -> {
                medicine = getTableView().getItems().get(getIndex());
                System.out.println(medicine.getName());

                // Add  logic here to handle the button click event
                Stage stage = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/onlineorder.fxml")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Online order");
                stage.setScene(new Scene(root, USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
                stage.setResizable(false);
                //stage.setOnHiding();
                stage.show();
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

    public void windowMyList(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/mylist.fxml")));
            stage.setTitle("My List");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }




    public void handleRadioButtonClick(ActionEvent actionEvent) {

        RadioButton radioButton = (RadioButton) actionEvent.getSource();

        if(radioButton.getText().equals("All")){
            refreshMedicine();
        }else{
        try {
            List<Category> listaKategorija =  categoryManager.searchCategoryId(radioButton.getText());
            medicineTable.setItems(FXCollections.observableList( medicineManager.searchByCategory(listaKategorija.get(0))));
            medicineTable.refresh();
        } catch (MedicineException e) {
            e.printStackTrace();
        }
        }
    }

}
