package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class CategoryDaoSQLImpl implements CategoryDao {

    private Connection connection;

    public CategoryDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582920", "sql7582920", "aymkDbW2ny");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Category getById(int id) {
        return null;
    }

    @Override
    public Category add(Category item) {
        return null;
    }

    @Override
    public Category update(Category item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
