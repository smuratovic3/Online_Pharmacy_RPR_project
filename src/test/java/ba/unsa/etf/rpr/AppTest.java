package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.CategoryManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.UserDao;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static ba.unsa.etf.rpr.controllers.MedicineController.medicine;
import static org.mockito.Mockito.when;

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


    @Mock
    private UserDao userDao;
    public User user = new User();
    private UserDaoSQLImpl usersDaoSQLMock = Mockito.mock(UserDaoSQLImpl.class);
    private UserManager userManager = new UserManager();

    @BeforeEach
    public void setUp() {
        user.setId(1);
        user.setName("Azra");
        user.setSurname("Muratovic");
        user.setAddress("Podigmanska 4");
        user.setPhone(Integer.parseInt("061923508"));
        user.setEmail("azra1@gmail.com");
        user.setPassword("azra123");
        MockitoAnnotations.openMocks(this);
        userManager = new UserManager();
    }


    /**
     * This method is testing registration
     * @throws MedicineException
     */
        @Test
         void register() throws MedicineException {
        User user = new User(1, "Azra", "Muratovic", "Podigmanska 4", "061923508", "azra1@gmail.com", "azra123");
        MockedStatic<DaoFactory> mockedFactory = Mockito.mockStatic(DaoFactory.class);
        mockedFactory.when(DaoFactory::userDao).thenReturn(usersDaoSQLMock);
        User expected = new User();
        when(usersDaoSQLMock.add(Mockito.any(User.class))).thenReturn(expected);
        User actual = usersDaoSQLMock.add(new User());
        assertEquals(expected, actual);
        mockedFactory.close();
    }
        @Test
        public void addTest() throws MedicineException {
        userDao.add(user);
        verify(userDao).add(user);
    }
        @Test
        void deleteTest() throws Exception {
        userDao.delete(1);
        verify(userDao).delete(1);
    }
}



