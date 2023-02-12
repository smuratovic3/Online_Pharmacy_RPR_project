package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.sql.SQLException;
import java.util.List;

/**
 * Dao interface for Category domain bean
 *
 * @author Semina Muratović
 */
public interface UserDao extends Dao<User> {
    User findEmail(String emailField) throws MedicineException;




}
