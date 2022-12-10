package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.IntermediateTable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class IntermediateTableDaoSQLImpl implements IntermediateTableDao {

    private Connection connection;

    public IntermediateTableDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582920", "sql7582920", "aymkDbW2ny");
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
