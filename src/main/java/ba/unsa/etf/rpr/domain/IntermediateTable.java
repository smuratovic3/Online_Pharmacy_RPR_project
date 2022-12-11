package ba.unsa.etf.rpr.domain;
import java.util.Objects;
/**
 * Intermediate table - one medicine can be in more than one order, and one order can contain more than one medicine
 * @author Semina Muratović
 **/
public class IntermediateTable {

    private Medicine medicine;
    private OrderOnline orderOnline;


    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public OrderOnline getOrderOnline() {
        return orderOnline;
    }

    public void setOrderOnline(OrderOnline orderOnline) {
        this.orderOnline = orderOnline;
    }
}
