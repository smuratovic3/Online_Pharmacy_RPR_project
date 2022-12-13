package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Category;
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
        String query = "SELECT * FROM quotes WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Medicine medicine = new Medicine();
                medicine.setId(rs.getInt("id"));
                medicine.setName(rs.getString("name"));
                medicine.setPrice(rs.getInt("price"));
                medicine.setDescription(rs.getString("description"));
                medicine.setPrescription(rs.getInt("prescription"));
                rs.close();
                return medicine;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
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
    public void delete(int id) {}

    @Override
    public List<Medicine> getAll() {return null;}

    @Override
    public List<Medicine> searchByCategory(Category category) {
        String query = "SELECT * FROM quotes WHERE category = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, category.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Medicine> quoteLista = new ArrayList<>();
            while (rs.next()) {
                Medicine q = new Medicine();
                q.setId(rs.getInt(1));
                q.setName(rs.getString(2));
                q.setPrice(rs.getInt(3));
                q.setQuantity(rs.getInt(1));
                q.setDescription(rs.getString(4));
                q.setPrescription(rs.getInt(5));
                q.setCategory(category);
                quoteLista.add(q);
            }
            return quoteLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
