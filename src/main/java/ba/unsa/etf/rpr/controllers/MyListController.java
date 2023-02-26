package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.IntermediateManager;
import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.domain.IntermediateTable;
import ba.unsa.etf.rpr.domain.Medicine;
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
    public TableView<Semina> listTable;
    @FXML
    public TableColumn<Semina, String> nameColumn = new TableColumn<>();
    @FXML
    public TableColumn<Semina, String> priceColumn = new TableColumn<>();
    @FXML
    public TableColumn<Semina, String> addressColumn = new TableColumn<>();

    @FXML
    private final IntermediateManager intermediateManager = new IntermediateManager();

    public void initialize(){
        Model model = Model.getInstance();

        nameColumn.setCellValueFactory(new PropertyValueFactory<Semina, String>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Semina, String>("price"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Semina,String>("address"));

        refreshMedicines();
    }

    void refreshMedicines() {
        try {
            Model model = Model.getInstance();
            List<IntermediateTable> lista = intermediateManager.getByUser(model.getUser().getId());
            List<Semina> seminaLista = new ArrayList<>();
            for(IntermediateTable t : lista){
                seminaLista.add(new Semina(t.getMedicine().getName(), t.getMedicine().getPrice(),t.getOrderOnline().getAddress()));
            }
            listTable.setItems(FXCollections.observableList(seminaLista));
            listTable.refresh();
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }



    public void actionClose(ActionEvent actionEvent)
    {
        Stage stage =(Stage)btnClose.getScene().getWindow();
        stage.close();
    }

    public class Semina{
        private String name;
        private Integer price;
        private String address;

        public Semina() {
        }

        public Semina(String name, Integer price, String address) {
            this.name = name;
            this.price = price;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

}
