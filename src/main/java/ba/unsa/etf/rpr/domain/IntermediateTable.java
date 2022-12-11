package ba.unsa.etf.rpr.domain;
import java.util.Objects;
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
