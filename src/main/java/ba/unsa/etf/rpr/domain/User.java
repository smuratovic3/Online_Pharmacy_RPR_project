package ba.unsa.etf.rpr.domain;
import java.util.Objects;

/**
 * Class that contains information about users.
 * @author Semina Muratovic
 */
public class User implements Idable {
    private int id;
    private String name;
    private String surname;
    private String address;
    private int phone;
    private String email;
    private String password;

    /**
     * Construtor with parametres
     * @param id
     * @param name
     * @param surname
     * @param address
     * @param phone
     * @param email
     * @param password
     */
    public User(int id,String name, String surname, String address, int phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    /**
     * Default constructor
     */
    public User() {
    }

    public User(int id, String azra, String muratovic, String address, String s, String email, String azra123) {
    }

    /**
     * Setter for id
     * @param id int
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for surname
     * @return String
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setter for surname
     * @param surname String
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }


    /**
     * Getter for address
     * @return String
     */
    public String getAddress() {
        return address;
    }


    /**
     * Setter for address
     * @param address String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User - " +
                "id=" + id +
                "name=" + name +
                "surname=" + surname +
                "address=" + address +
                "phone=" + phone +
                ", email=" + email +
                '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,surname,address,phone,email,password);
    }


}
