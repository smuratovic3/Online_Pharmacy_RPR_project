package ba.unsa.etf.rpr.exceptions;

public class MedicineException extends Exception{

    public MedicineException(String msg, Exception reason){
        super(msg, reason);
    }

    public MedicineException(String msg){
        super(msg);
    }
}
