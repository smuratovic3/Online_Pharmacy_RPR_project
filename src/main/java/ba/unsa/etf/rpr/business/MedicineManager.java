package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.util.Date;
import java.util.List;

/**
 * Business Logic Layer for Medicines
 *
 * @author Semina Muratovic
 */
public class MedicineManager {

    public List<Medicine> getAll() throws MedicineException {
        return DaoFactory.medicineDao().getAll();
    }

    public  List<Medicine> searchMedicine(String text) throws MedicineException {
        return DaoFactory.medicineDao().searchByText(text);
    }

    public void delete(int id) throws MedicineException{
        DaoFactory.medicineDao().delete(id);
    }

    public Medicine getById(int medicine_Id) throws MedicineException{
        return DaoFactory.medicineDao().getById(medicine_Id);
    }

    public void update(Medicine q) throws MedicineException{
        DaoFactory.medicineDao().update(q);
    }

    public Medicine add(Medicine q) throws MedicineException{
        return DaoFactory.medicineDao().add(q);
    }



}