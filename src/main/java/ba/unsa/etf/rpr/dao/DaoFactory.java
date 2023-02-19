package ba.unsa.etf.rpr.dao;


/**
 * The DaoFactory class provides static methods to get instances of CategoryDao, UserDao, MedicineDao, OnlineOrderDao, IntermediateDao.
 * These instances are implemented using the SQL database, using the SQL implementations of each Dao.
 * @author Semina Muratovic
 */
public class DaoFactory {
    private static final CategoryDao categoryDao = CategoryDaoSQLImpl.getInstance();
    private static final MedicineDao medicineDao = MedicineDaoSQLImpl.getInstance();
    private static final OnlineOrderDao onlineOrderDao = OnlineOrderDaoSQLImpl.getInstance();
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private static final IntermediateDao intermediateDao = IntermediateDaoSQLImpl.getInstance();

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
    public static IntermediateDao intermediateDao()
    {
        return intermediateDao;
    }




}
