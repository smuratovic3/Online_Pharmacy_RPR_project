/*IntermediateDao
        package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.IntermediateTable;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.util.List;

public interface IntermediateDao extends Dao<IntermediateTable> {
    List<Medicine> getByUser(int idUser) throws MedicineException;

}
//////////////////////////////////////////////////////////////////////////
 */

/*IntermediateDaoSQLImpl
        package ba.unsa.etf.rpr.dao;

        import ba.unsa.etf.rpr.business.IntermediateManager;
        import ba.unsa.etf.rpr.domain.IntermediateTable;
        import ba.unsa.etf.rpr.domain.Medicine;
        import ba.unsa.etf.rpr.exceptions.MedicineException;
        import java.sql.ResultSet;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Map;
        import java.util.TreeMap;

/**
 * MySQL Implementation of DAO
 * @author Semina Muratovic
 */
/*
public class IntermediateDaoSQLImpl extends AbstractDao<IntermediateTable> implements IntermediateDao {

    private static IntermediateDaoSQLImpl instance = null;
    private IntermediateDaoSQLImpl()
    {
        super("IntermediateTable");
    }


    /**
     * @author Semina Muratovic
     * @return MedicineDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'Medicine' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     */
 /*   public static IntermediateDaoSQLImpl getInstance()
    {
        if(instance==null)
            instance = new IntermediateDaoSQLImpl();
        return instance;
    }

    public static void removeInstance()
    {
        if(instance!=null)
            instance=null;
    }

    /**
     * @param rs The result set from the database query
     * @return A intermediate  object with properties set according to the values in the result set
     * @throws MedicineException if there is an error when retrieving values from the result set
     */
/*
    @Override
    public IntermediateTable row2object(ResultSet rs) throws MedicineException
    {
        try {
            IntermediateTable q = new IntermediateTable();
            q.setId(rs.getInt("id"));
            q.setMedicine(DaoFactory.medicineDao().getById(rs.getInt("medicine_Id")));
            q.setOrderOnline(DaoFactory.onlineOrderDao().getById(rs.getInt("onlineOrder_Id")));
            return q;
        } catch (Exception e) {
            throw new MedicineException(e.getMessage(), e);
        }
    }

    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
   /* @Override
    public Map<String, Object> object2row(IntermediateTable object)
    {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("medicine_Id", object.getMedicine().getId());
        item.put("onlineOrder_Id", object.getOrderOnline().getId());
        return item;
    }

    /**
     * Fetches all orders from database with given idUser
     * @param idUser int
     * @return List of Medicines
     * @throws MedicineException in case of problems with database
     */
 /*   @Override
    /*public List<Medicine> getByUser(int idUser) throws MedicineException {
        try {
            List<Medicine> medicines = new ArrayList<>();
            IntermediateManager intermediateManager = new IntermediateManager();
            List<IntermediateTable> intermediateTables = new ArrayList<>(intermediateManager.getAll());
            for (IntermediateTable intermediateTable : intermediateTables) {
                if (intermediateTable.getOrderOnline().getUser().getId() == idUser) {
                    medicines.add(intermediateTable.getMedicine());

                }
            }
            return medicines;
        }
        catch (Exception e) {
            throw new MedicineException(e.getMessage(), e);
        }
    }*/

  /*  public List<Medicine> getByUser(int idUser) throws MedicineException {
        try {
            List<Medicine> medicines = new ArrayList<>();
            IntermediateManager intermediateManager = new IntermediateManager();
            List<IntermediateTable> intermediateTables = new ArrayList<>(intermediateManager.getAll());
            for (IntermediateTable intermediateTable : intermediateTables) {
                if (intermediateTable.getOrderOnline().getUser().getId() == idUser) {
                    Medicine medicine = intermediateTable.getMedicine();
                    medicine.setPrice(intermediateTable.getMedicine().getPrice());
                    medicines.add(medicine);
                }
            }
            return medicines;
        }
        catch (Exception e) {
            throw new MedicineException(e.getMessage(), e);
        }
    }


    IntermediateManager
package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.IntermediateTable;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.util.List;

    public class IntermediateManager {
        public IntermediateTable add(IntermediateTable q) throws MedicineException
        {
            return DaoFactory.intermediateDao().add(q);
        }
        public List<IntermediateTable> getAll() throws MedicineException {
            return DaoFactory.intermediateDao().getAll();
        }

        public List<Medicine> getByUser(int idUser) throws MedicineException {
            return DaoFactory.intermediateDao().getByUser(idUser);
        }

    }

    MyListController
package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.IntermediateManager;
import ba.unsa.etf.rpr.business.MedicineManager;
import ba.unsa.etf.rpr.domain.Medicine;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


    public class MyListController {
        public Button btnClose;

        @FXML
        public TableView<Medicine> listTable;
        @FXML
        public TableColumn<Medicine, String> nameColumn = new TableColumn<>();
        @FXML
        public TableColumn<Medicine, String> priceColumn = new TableColumn<>();

        @FXML
        private final IntermediateManager intermediateManager = new IntermediateManager();



        public void initialize(){
            Model model = Model.getInstance();

            nameColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<Medicine, String>("price"));

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
        public void actionClose(ActionEvent actionEvent)
        {
            Stage stage =(Stage)btnClose.getScene().getWindow();
            stage.close();
        }

    }



}
*/
