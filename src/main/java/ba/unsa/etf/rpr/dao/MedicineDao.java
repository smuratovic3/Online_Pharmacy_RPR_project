package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Category;
import ba.unsa.etf.rpr.domain.Medicine;

import java.util.List;

/**
 * Dao interface for Category domain bean
 *
 * @author Semina Muratović
 */
public interface MedicineDao extends Dao<Medicine> {
    List<Medicine> searchByCategory(Category category);
}
