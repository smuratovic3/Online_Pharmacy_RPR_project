package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.collections.FXCollections;
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
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class MedicineController {

    @FXML
    public TableView<Medicine> medicineTable;
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
        System.out.println("User" + " " + loggedUserId);
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
                Model model = Model.getInstance();
                model.setMedicine(medicine);
                System.out.println(medicine.getName());

                // Add  logic here to handle the button click event
                try {
                    Stage stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/onlineorder.fxml"));
                    OnlineOrderController onlineOrderController = new OnlineOrderController();
                    loader.setController(onlineOrderController);
                    Parent root = loader.load();
                    stage.setTitle("Online order");
                    stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                    stage.setResizable(false);
                    //stage.setOnHiding();
                    stage.show();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
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

    public void actionAboutUs(ActionEvent actionEvent) throws IOException
    {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/aboutus.fxml"));
            AboutUsController aboutUsController = new AboutUsController();
            loader.setController(aboutUsController);
            Parent root = loader.load();
            stage.setTitle("About us");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            //stage.setOnHiding();
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void helpAction(ActionEvent actionEvent) throws IOException
    {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/help.fxml"));
            HelpController helpController = new HelpController();
            loader.setController(helpController);
            Parent root = loader.load();
            stage.setTitle("Help");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            //stage.setOnHiding();
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void windowMyList(ActionEvent actionEvent) {

        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mylist.fxml"));
            MyListController myListController = new MyListController();
            loader.setController(myListController);
            Parent root = loader.load();
            stage.setTitle("My list");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            //stage.setOnHiding();
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
