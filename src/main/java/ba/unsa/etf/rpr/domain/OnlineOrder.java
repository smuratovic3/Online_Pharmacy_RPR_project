package ba.unsa.etf.rpr.domain;
import java.util.Objects;

/**
 * Information about ordering online
 * @author Semina Muratović
 **/
public class OnlineOrder implements Idable {
    private int id;
    private int payment;
    private int bill;
    private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
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
                ", payment='" + payment + '\'' +
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
        return Objects.hash(id, payment,bill,user);
    }
}
