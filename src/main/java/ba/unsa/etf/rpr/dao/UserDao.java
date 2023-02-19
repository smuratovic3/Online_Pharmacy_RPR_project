package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MedicineException;

/**
 * Dao interface for Category domain bean
 * @author Semina Muratović
 */
public interface UserDao extends Dao<User> {
    User findEmail(String emailField) throws MedicineException;
    
}
