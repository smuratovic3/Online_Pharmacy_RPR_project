package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import org.junit.jupiter.api.Test;

import static ba.unsa.etf.rpr.controllers.MedicineController.medicine;
import static org.junit.jupiter.api.Assertions.*;

/**
 * *Tests for my App
 * @author Semina Muratovic
 */

public class AppTest {

    @Test
    public void validateCategoryName1() throws MedicineException {
        // Test for a valid category name
        CategoryManager categoryManager = new CategoryManager();
        categoryManager.validateCategoryName("Headache");
        // Test for a name that is too short
        try {
            categoryManager.validateCategoryName("A");
            fail("Expected MedicineException was not thrown");
        } catch (MedicineException e) {
            assertEquals("Medicine name must be between 3 and 45 chars", e.getMessage());
        }
    }


    @Test
    public void validateCategoryName2() throws MedicineException {
        // Test for a valid category name
        CategoryManager categoryManager = new CategoryManager();
        categoryManager.validateCategoryName("Headache");
        // Test for a name that is too long
        try {
            categoryManager.validateCategoryName("This category name is too long and should not be allowed");
            fail("Expected MedicineException was not thrown");
        } catch (MedicineException e) {
            assertEquals("Medicine name must be between 3 and 45 chars", e.getMessage());
        }
    }

   






}



