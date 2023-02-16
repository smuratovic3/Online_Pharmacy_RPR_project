package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import org.junit.jupiter.api.Test;

import static ba.unsa.etf.rpr.controllers.MedicineController.medicine;
import static org.junit.jupiter.api.Assertions.*;

/**
 * *Tests for my App
 * @author Semina Muratovic
 */

public class AppTest {

    /**
     * Tests if setters and getters in 'Medicine' are valid
     */
    @Test
    public void getName() {
        medicine.setName("Medicine A");
        assertEquals("Medicine A", medicine.getName());
    }
    @Test
    public void getPrice() {
        medicine.setPrice(10);
        assertEquals(10, medicine.getPrice());
    }

    @Test
    public void equals() {
        medicine.setId(1);
        Medicine otherMedicine = new Medicine();
        otherMedicine.setId(1);
        assertTrue(medicine.equals(otherMedicine));
    }


    //User konstruktor
    @Test
    public void testUserConstructor() {
        User user = new User(1, "John", "Doe", "123 Main St", 5551234, "john.doe@example.com", "password123");
        assertEquals(1, user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getSurname());
        assertEquals("123 Main St", user.getAddress());
        assertEquals(5551234, user.getPhone());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testUserSetterGetter() {
        User user = new User();
        user.setId(2);
        user.setName("Jane");
        user.setSurname("Doe");
        user.setAddress("456 Oak St");
        user.setPhone(5555678);
        user.setEmail("jane.doe@example.com");
        user.setPassword("abc123");
        assertEquals(2, user.getId());
        assertEquals("Jane", user.getName());
        assertEquals("Doe", user.getSurname());
        assertEquals("456 Oak St", user.getAddress());
        assertEquals(5555678, user.getPhone());
        assertEquals("jane.doe@example.com", user.getEmail());
        assertEquals("abc123", user.getPassword());
    }
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

    @Test
    public void validateCategoryName3() throws MedicineException {
        // Test for a valid category name
        CategoryManager categoryManager = new CategoryManager();
        categoryManager.validateCategoryName("Headache");
        // Test for a null name
        try {
            categoryManager.validateCategoryName(null);
            fail("Expected MedicineException was not thrown");
        } catch (MedicineException e) {
            assertEquals("Medicine name must be between 3 and 45 chars", e.getMessage());
        }
    }









}



