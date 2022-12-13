package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Medicine;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MedicineDaoSQLImpl implements MedicineDao {

    private Connection connection;

    public MedicineDaoSQLImpl(){
        try{
            FileReader reader = new FileReader("src/main/resources/database.properties");
            Properties p = new Properties();
            p.load(reader);
            String s1 = p.getProperty("url");
            String s2 = p.getProperty("user");
            String s3 = p.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(s1,s2,s3);
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
