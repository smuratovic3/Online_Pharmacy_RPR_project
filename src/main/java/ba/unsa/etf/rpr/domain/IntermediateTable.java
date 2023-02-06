package ba.unsa.etf.rpr.domain;

/**
 * Intermediate table - one medicine can be in more than one order, and one order can contain more than one medicine
 * @author Semina Muratović
 **/
public class IntermediateTable {

    private Medicine medicine;
    private OnlineOrder orderOnline;


    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public OnlineOrder getOrderOnline() {
        return orderOnline;
    }

    public void setOrderOnline(OnlineOrder orderOnline) {
        this.orderOnline = orderOnline;
    }
}
