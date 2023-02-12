package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Medicine;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserManager {
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
    public User add(User r) throws MedicineException {
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

    public User findEmail(String emailField) throws MedicineException{
        return DaoFactory.userDao().findEmail(emailField);
    }

    private static final String HASHING_ALGORITHM = "SHA-256";

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(HASHING_ALGORITHM);
        messageDigest.update(password.getBytes());

        byte[] hashedPassword = messageDigest.digest();

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashedPassword) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }


}
