package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL Implementation of DAO
 * @author Semina Muratovic
 */

public class MedicineDaoSQLImpl extends AbstractDao<Medicine> implements MedicineDao {

    private static MedicineDaoSQLImpl instance = null;
    private MedicineDaoSQLImpl()
    {
        super("Medicine");
    }

    /**
     * @author Semina Muratovic
     * @return MedicineDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'Medicine' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     */
    public static MedicineDaoSQLImpl getInstance()
    {
        if(instance==null)
            instance = new MedicineDaoSQLImpl();
        return instance;
    }

    public static void removeInstance()
    {
        if(instance!=null)
            instance=null;
    }

    @Override
    public Medicine row2object(ResultSet rs) throws MedicineException
    {
        try {
            Medicine q = new Medicine();
            q.setId(rs.getInt("id"));
            q.setName(rs.getString("name"));
            q.setPrice(rs.getInt("price"));
            q.setQuantity(rs.getInt("quantity"));
            q.setDescription(rs.getString("description"));
            q.setCategory(DaoFactory.categoryDao().getById(rs.getInt("categories_Id")));
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
    public Map<String, Object> object2row(Medicine object)
    {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("name", object.getName());
        item.put("price", object.getPrice());
        item.put("quantity", object.getQuantity());
        item.put("description", object.getDescription());
        item.put("categories_Id", object.getCategory().getId());
        return item;
    }

    /**
     * @param text search string for medicine
     * @return list of medicines
     * @author Semina Muratovic
     */

    @Override
    public List<Medicine> searchByText(String text) throws MedicineException
    {
        return executeQuery("SELECT * FROM Medicine WHERE name LIKE concat('%', ?, '%')", new Object[]{text});
    }

    /**
     * @param category search string for medicines
     * @return list of medicine
     * @author Semina Muratovic
     */
    @Override
    public List<Medicine> searchByCategory(Category category) throws MedicineException
    {
        return executeQuery("SELECT * FROM Medicine WHERE categories_Id = ?", new Object[]{category.getId()});
    }







}