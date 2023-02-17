package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.util.List;

/**
 * Dao interface for Category domain bean
 *
 * @author Semina Muratović
 */
public interface CategoryDao extends Dao<Category> {


    List<Category> searchCategoryId(String categoryName) throws MedicineException;

}
