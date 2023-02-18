package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MedicineException;
import java.util.List;

public class UserManager {
    public static User findEmail(String emailField) throws MedicineException {
        return DaoFactory.userDao().findEmail(emailField);
    }

    public void delete(int UserId) throws MedicineException {
        try {
            DaoFactory.userDao().delete(UserId);
        } catch (MedicineException e) {
            if (e.getMessage().contains("FOREIGN KEY")) {
                throw new MedicineException("NO");
            }
            throw e;
        }

    }
    public static User add(User r) throws MedicineException {
        return DaoFactory.userDao().add(r);
    }

    public User getById(int id) throws MedicineException {
        return DaoFactory.userDao().getById(id);
    }

    public User update(User r) throws MedicineException {
        return DaoFactory.userDao().update(r);
    }

    public List<User> getAll() throws MedicineException {
        return DaoFactory.userDao().getAll();
    }






    }
