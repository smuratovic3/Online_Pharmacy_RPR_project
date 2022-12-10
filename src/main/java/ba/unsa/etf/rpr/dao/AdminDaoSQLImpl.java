package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Admin;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AdminDaoSQLImpl implements AdminDao {

    private Connection connection;

    public AdminDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582920", "sql7582920", "aymkDbW2ny");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Admin getById(int id) {
        return null;
    }

    @Override
    public Admin add(Admin item) {
        return null;
    }

    @Override
    public Admin update(Admin item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Admin> getAll() {
        return null;
    }
}
