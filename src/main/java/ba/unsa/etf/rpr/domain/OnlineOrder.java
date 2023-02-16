package ba.unsa.etf.rpr.domain;
import java.util.Objects;

/**
 * Class that contains information about reservations made for medicines.
 * @author Seminaa Muratovic
 */
public class OnlineOrder implements Idable {
    private int id;

    private int bill;
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



    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
