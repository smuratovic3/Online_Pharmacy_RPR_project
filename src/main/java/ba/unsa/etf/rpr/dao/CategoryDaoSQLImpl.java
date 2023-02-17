package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySql implementation of the DAO
 * @author Semina Muratovic
 */
public class CategoryDaoSQLImpl extends AbstractDao<Category> implements CategoryDao{
    private static  CategoryDaoSQLImpl instance = null;
    private CategoryDaoSQLImpl() {
        super("Categories");
    }

    public static CategoryDaoSQLImpl getInstance()
    {
        if(instance==null)
            instance = new CategoryDaoSQLImpl();
        return instance;
    }

    public static void removeInstance()
    {
        if(instance!=null)
            instance=null;
    }

    @Override
    public Category row2object(ResultSet rs) throws MedicineException
    {
        try {
            Category cat = new Category();
            cat.setId(rs.getInt("id"));
            cat.setName(rs.getString("name"));
            return cat;
        } catch (SQLException e) {
            throw new MedicineException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Category object)
    {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        return row;
    }

    @Override
    public List<Category> searchCategoryId(String categoryName) throws MedicineException
    {
        return executeQuery("SELECT * FROM Categories WHERE name = ?", new Object[]{categoryName});
    }
}