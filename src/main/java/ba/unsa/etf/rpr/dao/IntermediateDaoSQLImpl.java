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
    public static IntermediateDaoSQLImpl getInstance()
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
    @Override
    public Map<String, Object> object2row(IntermediateTable object)
    {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("medicine_Id", object.getMedicine().getId());
        item.put("onlineOrder_Id", object.getOrderOnline().getId());
        return item;
    }
    @Override
    public List<Medicine> getByUser(int idUser) throws MedicineException {
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
    }



}