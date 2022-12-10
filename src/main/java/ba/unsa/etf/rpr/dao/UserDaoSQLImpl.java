package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDaoSQLImpl implements UserDao {

    private Connection connection;

    public UserDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582920", "sql7582920", "aymkDbW2ny");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User add(User item) {
        return null;
    }

    @Override
    public User update(User item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
