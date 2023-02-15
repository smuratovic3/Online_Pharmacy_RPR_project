package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.domain.OnlineOrder;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import java.sql.*;
import java.util.*;

public class OnlineOrderDaoSQLImpl extends AbstractDao<OnlineOrder> implements OnlineOrderDao {
    private static OnlineOrderDaoSQLImpl instance = null;
    private OnlineOrderDaoSQLImpl()
    {
        super("OnlineOrder");
    }

    /**
     * @author Semina Muratovic
     * @return OnlineOrderDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'OnlineOrder' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     */
    public static OnlineOrderDaoSQLImpl getInstance()
    {
        if(instance==null)
            instance = new OnlineOrderDaoSQLImpl();
        return instance;
    }

    public static void removeInstance()
    {
        if(instance!=null)
            instance=null;
    }

    @Override
    public OnlineOrder row2object(ResultSet rs) throws MedicineException
    {
        try {
            OnlineOrder q = new OnlineOrder();
            q.setId(rs.getInt("id"));
            q.setBill(rs.getInt("bill"));
            q.setUser(DaoFactory.onlineOrderDao().getById(rs.getInt("user_Id")).getUser());
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
    public Map<String, Object> object2row(OnlineOrder object)
    {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("bill", object.getBill());
        item.put("user_Id", object.getUser().getId());
        return item;
    }


}
