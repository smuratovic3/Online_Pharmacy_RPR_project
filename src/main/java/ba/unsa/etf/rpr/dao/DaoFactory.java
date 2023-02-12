package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.OnlineOrder;
import ba.unsa.etf.rpr.domain.User;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Semina Muratovic
 */
public class DaoFactory {
    private static final CategoryDao categoryDao = CategoryDaoSQLImpl.getInstance();
    private static final MedicineDao medicineDao = MedicineDaoSQLImpl.getInstance();
    private static final OnlineOrderDao onlineOrderDao = OnlineOrderDaoSQLImpl.getInstance();
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();

    private DaoFactory(){}

    public static CategoryDao categoryDao()
    {
        return categoryDao;
    }

    public static MedicineDao medicineDao()
    {
        return medicineDao;
    }
    public static OnlineOrderDao onlineOrderDao()
    {
        return onlineOrderDao;
    }
    public static UserDao userDao()
    {
        return userDao;
    }



}
