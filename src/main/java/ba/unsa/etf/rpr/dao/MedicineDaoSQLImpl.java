package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Medicine;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MedicineDaoSQLImpl implements MedicineDao {

    private Connection connection;

    public MedicineDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582920", "sql7582920", "aymkDbW2ny");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Medicine getById(int id) {
        return null;
    }

    @Override
    public Medicine add(Medicine item) {
        return null;
    }

    @Override
    public Medicine update(Medicine item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Medicine> getAll() {
        return null;
    }
}
