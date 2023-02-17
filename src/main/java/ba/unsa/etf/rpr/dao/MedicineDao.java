package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.util.List;

/**
 * Dao interface for Medicine domain bean
 *
 * @author Semina
 */
public interface MedicineDao extends Dao<Medicine>{

    /**
     * Returns all medicines that contains given text.
     *
     * @param text search string for medicines
     * @return list of medicines
     */
    List<Medicine> searchByText(String text) throws MedicineException;

    /**
     * Returns all medicines that contains given text.
     *
     * @param category search string for quotes
     * @return list of medicines
     */
    List<Medicine> searchByCategory(Category category) throws MedicineException;

    /**
     * Return random quote from database
     *
     * @return random quote
     * @throws MedicineException
     */



}