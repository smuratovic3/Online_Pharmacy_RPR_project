package ba.unsa.etf.rpr.domain;

/**
 *  This class is Intermediate table - one medicine can be in more than one order, and one order can contain more than one medicine
 * @author Semina Muratović
 **/
public class IntermediateTable implements Idable {



    private int id;
    private Medicine medicine;
    private OnlineOrder orderOnline;


    /**
     * This class provides getters and setters for accessing and modifying the medicine and online order associated with the intermediate table entry.
     */
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


     @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
