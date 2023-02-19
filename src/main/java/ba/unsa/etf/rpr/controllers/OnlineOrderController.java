package ba.unsa.etf.rpr.controllers;


import ba.unsa.etf.rpr.business.IntermediateManager;
import ba.unsa.etf.rpr.business.OnlineOrderManager;
import ba.unsa.etf.rpr.domain.IntermediateTable;
import ba.unsa.etf.rpr.domain.OnlineOrder;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class OnlineOrderController {
    public Button btnCancel;
    public Label medicineName;
    public Label medicinePrice;
    public Label medicineQuantity;
    public Label medicineDescription;
    OnlineOrderManager onlineOrderManager = new OnlineOrderManager();
    private String email;



    @FXML
    public void initialize()
    {
        medicineName.setText(MedicineController.medicine.getName());
        medicinePrice.setText(String.valueOf(MedicineController.medicine.getPrice()) + "$");
        medicineQuantity.setText(String.valueOf(MedicineController.medicine.getQuantity()));
        medicineDescription.setText(MedicineController.medicine.getDescription());

    }

    public void insertData() throws MedicineException {
        Model model = Model.getInstance();
        OnlineOrder onlineOrder = new OnlineOrder();
        onlineOrder.setUser(model.getUser());
        onlineOrder.setBill(model.getMedicine().getPrice());
        onlineOrderManager.add(onlineOrder);

        IntermediateTable intermediateTable = new IntermediateTable();
        List<OnlineOrder> lista = onlineOrderManager.getAll();
       // System.out.println("OK ");
        for(OnlineOrder o : lista){
            if(o.getBill() == onlineOrder.getBill() && o.getUser().equals(onlineOrder.getUser())){
                model.setOnlineOrder(o);

                intermediateTable.setOrderOnline(model.getOnlineOrder());
                System.out.println("OK " + model.getOnlineOrder());
                //
                //
                // System.out.println("OK ");
            }
        }

        intermediateTable.setMedicine(model.getMedicine());
        System.out.println( intermediateTable.getMedicine().getName() + " " + intermediateTable.getOrderOnline().getBill());
        IntermediateManager intermediateManager = new IntermediateManager();
        intermediateManager.add(intermediateTable);


    }


    public void confirm(ActionEvent actionEvent) {

        try {
            insertData();
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/confirmorder.fxml"));
            ConfirmOrderController confirmOrderController = new ConfirmOrderController();
            loader.setController(confirmOrderController);
            Parent root = loader.load();
            stage.setTitle("Confirm order");
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            //stage.setOnHiding();
            stage.show();
        } catch (IOException | MedicineException e) {
            System.out.println(e.getMessage());
        }

    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage =(Stage)btnCancel.getScene().getWindow();
        stage.close();
    }
}
