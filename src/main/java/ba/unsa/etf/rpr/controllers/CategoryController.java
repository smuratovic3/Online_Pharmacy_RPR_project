package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * JavaFX controller for category management
 *
 * @author Semina Muratovic
 */
public class CategoryController {

    private CategoryManager manager = new CategoryManager();

    // components
    public ListView<Category> categoriesList;
    public TextField categoryName;
    public TableView<Medicine> medicinesTable;

    @FXML
    public void initialize()
    {
        try {
            refreshCategories();
            categoriesList.getSelectionModel().selectedItemProperty().addListener((obs, o, n)->{
                if (n != null){
                    categoryName.setText(n.getName());
                }
            });
        } catch (MedicineException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }


    private void refreshCategories() throws MedicineException
    {
        try {
            categoriesList.setItems(FXCollections.observableList(manager.getAll()));
            categoryName.setText("");
        } catch (MedicineException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }


}