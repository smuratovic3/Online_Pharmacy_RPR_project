package ba.unsa.etf.rpr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class AppFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/pocetna.fxml"));
        primaryStage.setTitle("Online Pharmacy");
        primaryStage.setScene(new Scene(root, 580, 400));
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) throws SQLException {
     /*  Connection connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_RPR_baza",
                "freedb_smuratovic3", "JSkRP5Z5XgZ7T*a");
        System.out.println("Connected to the database");

        String query = "SELECT * FROM Medicine";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(metaData.getColumnName(i) + " " + metaData.getColumnTypeName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
       /* String query2 = "SELECT * FROM Categories";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query2)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(metaData.getColumnName(i) + " " + metaData.getColumnTypeName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

*/

      /*String query2 = "INSERT INTO Medicine (name, quantity,description) VALUES ('Analgin', 100, 'Good for a headache')";
        try (PreparedStatement preparedStmt = connection.prepareStatement(query2)) {
            preparedStmt.setString(1, "Analgin");
            preparedStmt.setInt(2, 100);
            preparedStmt.setString(3, "Good for a headache");
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/



         launch(args);
    }
}
