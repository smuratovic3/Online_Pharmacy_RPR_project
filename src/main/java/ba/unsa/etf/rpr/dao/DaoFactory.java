package ba.unsa.etf.rpr.dao;


/**
 * The DaoFactory class provides static methods to get instances of CategoryDao, UserDao, MedicineDao, OnlineOrderDao, IntermediateDao.
 * These instances are implemented using the SQL database, using the SQL implementations of each Dao.
 * @author Semina Muratovic
 */
public class DaoFactory {
    /**
     * A singleton instance of the CategoryDao class, which is used to access and manipulate train data in a database.
     */
    private static final CategoryDao categoryDao = CategoryDaoSQLImpl.getInstance();

    /**
     * A singleton instance of the MedicineDao class, which is used to access and manipulate train data in a database.
     */
    private static final MedicineDao medicineDao = MedicineDaoSQLImpl.getInstance();

    /**
     * A singleton instance of the OnlineOrderDao class, which is used to access and manipulate train data in a database.
     */
    private static final OnlineOrderDao onlineOrderDao = OnlineOrderDaoSQLImpl.getInstance();

    /**
     * A singleton instance of the UserDao class, which is used to access and manipulate train data in a database.
     */
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();

    /**
     * A singleton instance of the IntermediateDao class, which is used to access and manipulate train data in a database.
     */
    private static final IntermediateDao intermediateDao = IntermediateDaoSQLImpl.getInstance();

    /**
     * A private constructor to prevent instantiation of this class.
     */
    private DaoFactory(){}

    /**
     * Returns a singleton instance of the CategoryDao class.
     * @return A singleton instance of the CategoryDao class.
     */
    public static CategoryDao categoryDao()
    {
        return categoryDao;
    }

    /**
     * Returns a singleton instance of the MedicineDao class.
     * @return A singleton instance of the MedicineDao class.
     */
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
