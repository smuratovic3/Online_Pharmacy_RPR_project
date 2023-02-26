package ba.unsa.etf.rpr.domain;
import java.util.Objects;

/**
 * Class that contains information about reservations made for medicines.
 * @author Seminaa Muratovic
 */
public class OnlineOrder implements Idable {
    private int id;

    private int bill;



    private String address;



    private int phonenumber;
    private User user;


    /**
     * Getter for Id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for Id
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Getter for Bill
     * @return bill
     */
    public int getBill() {
        return bill;
    }

    /**
     * Setter for Id
     * @param bill int
     */
    public void setBill(int bill) {
        this.bill = bill;
    }

    /**
     * Getter for user
     * @return User
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for User
     * @param user User
     */
    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "Order: " +
                "id=" + id +

                ", bill=" + bill +
                ", user=" + user +
                '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnlineOrder orderOnline = (OnlineOrder) o;
        return id == orderOnline.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bill,user);
    }
}
