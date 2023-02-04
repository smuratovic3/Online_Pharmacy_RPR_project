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
    private MedicineDaoSQLImpl() {
        super("quotes");
    }

    /**
     * @author Semina Muratovic
     * @return MedicineDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'quotes' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     */
    public static MedicineDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new MedicineDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Medicine row2object(ResultSet rs) throws MedicineException{
        try {
            Medicine q = new Medicine();
            q.setId(rs.getInt("id"));
            q.setName(rs.getString("medicine"));
            q.setCategory(DaoFactory.categoryDao().getById(rs.getInt("category_id")));
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
    public Map<String, Object> object2row(Medicine object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("medicine", object.getName());
        item.put("category_id", object.getCategory().getId());
        return item;
    }

    /**
     * @param text search string for quotes
     * @return list of quotes
     * @author Semina Muratovic
     */

    @Override
    public List<Medicine> searchByText(String text) throws MedicineException{
        return executeQuery("SELECT * FROM quotes WHERE quote LIKE concat('%', ?, '%')", new Object[]{text});
    }

    /**
     * @param category search string for quotes
     * @return list of quotes
     * @author Semina Muratovic
     */
    @Override
    public List<Medicine> searchByCategory(Category category) throws MedicineException{
        return executeQuery("SELECT * FROM quotes WHERE category_id = ?", new Object[]{category.getId()});
    }

    /**
     * @return random quote from DB
     * @throws MedicineException in case of error working with db
     */
    @Override
    public Medicine randomQuote() throws MedicineException {
        return executeQueryUnique("SELECT * FROM quotes ORDER BY RAND() LIMIT 1", null);
    }
}