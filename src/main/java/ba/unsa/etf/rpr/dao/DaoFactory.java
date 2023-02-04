package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Semina Muratovic
 */
public class DaoFactory {

    private static final CategoryDao categoryDao = CategoryDaoSQLImpl.getInstance();
    private static final MedicineDao medicineDao = MedicineDaoSQLImpl.getInstance();
    private DaoFactory(){
    }

    public static CategoryDao categoryDao(){
        return categoryDao;
    }

    public static MedicineDao medicineDao(){
        return medicineDao;
    }



}
