package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.MedicineException;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MedicineException
    {
        System.out.println( "Hello user. Welcome to online pharmacy. This is a simple app for ordering medicines.");
        System.out.println("If you don't have a account type 1, if you already have one type 2.");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        if (type == 2) {
            String email;
            String password;
            System.out.println("Email: ");
            Scanner scanner1 = new Scanner(System.in);
            email = scanner1.next();
            System.out.println("Password: ");
            password = scanner1.next();

            User user = DaoFactory.userDao().findEmail(email);
            //System.out.println(user);
            while (true) {
                if (user != null && user.getPassword().equals(password)) {
                    System.out.println("Login successful\n");
                    break;
                }
                System.out.println("Username or password is wrong. Please try again.");

                System.out.println("Email: ");
                Scanner scanner2 = new Scanner(System.in);
                email = scanner2.next();
                System.out.println("Password: ");
                password = scanner2.next();
                user = DaoFactory.userDao().findEmail(email);

            }
        }
        else  if (type == 1) {
            try {
                String name;
                String surname;
                String address;
                String phone;
                String email;
                String password;

                System.out.println("Name: ");
                Scanner nameSc = new Scanner(System.in);
                name = nameSc.next();
                System.out.println("Surname: ");
                Scanner surnameSc = new Scanner(System.in);
                surname = surnameSc.next();
                System.out.println("Address: ");
                Scanner addressSc = new Scanner(System.in);
                address = addressSc.next();
                System.out.println("Phone: ");
                Scanner phoneSc = new Scanner(System.in);
                phone = phoneSc.next();
                System.out.println("Email: ");
                Scanner emailSc = new Scanner(System.in);
                email = emailSc.next();
                System.out.println("Password: ");
                Scanner passwordSc = new Scanner(System.in);
                password = passwordSc.next();
                User user = new User();
                user.setName(name);
                user.setPhone(Integer.parseInt(phone));
                user.setSurname(surname);
                user.setEmail(email);
                user.setAddress(address);
                user.setPassword(password);
                UserManager.add(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }






    }
}
