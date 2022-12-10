package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.OrderOnline;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class OrderOnlineDaoSQLImpl implements OrderOnlineDao {

    private Connection connection;

    public OrderOnlineDaoSQLImpl(){
        try{
            this.connection = DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582920", "sql7582920", "aymkDbW2ny");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public OrderOnline getById(int id) {
        return null;
    }

    @Override
    public OrderOnline add(OrderOnline item) {
        return null;
    }

    @Override
    public OrderOnline update(OrderOnline item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<OrderOnline> getAll() {
        return null;
    }
}
