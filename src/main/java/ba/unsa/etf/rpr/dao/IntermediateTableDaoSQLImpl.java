package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.IntermediateTable;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class IntermediateTableDaoSQLImpl implements IntermediateTableDao {

    private Connection connection;

    public IntermediateTableDaoSQLImpl(){
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
    public IntermediateTable getById(int id) {
        return null;
    }

    @Override
    public IntermediateTable add(IntermediateTable item) {
        return null;
    }

    @Override
    public IntermediateTable update(IntermediateTable item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<IntermediateTable> getAll() {
        return null;
    }
}
