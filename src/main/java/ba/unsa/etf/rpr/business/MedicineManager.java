package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Business Logic Layer for Medicines
 *
 * @author Semina Muratovic
 */
public class MedicineManager {

    public List<Medicine> getAll() throws MedicineException
    {
        return DaoFactory.medicineDao().getAll();
    }

    public  List<Medicine> searchMedicine(String text) throws MedicineException
    {
        return DaoFactory.medicineDao().searchByText(text);
    }

    public void delete(int id) throws MedicineException
    {
        DaoFactory.medicineDao().delete(id);
    }

    public Medicine getById(int id) throws MedicineException
    {
        return DaoFactory.medicineDao().getById(id);
    }

    public void update(Medicine q) throws MedicineException
    {
        DaoFactory.medicineDao().update(q);
    }

    public Medicine add(Medicine q) throws MedicineException
    {
        return DaoFactory.medicineDao().add(q);
    }

    public List<Medicine> searchByCategory(Category category) throws MedicineException{
        return DaoFactory.medicineDao().searchByCategory(category);
    }




}