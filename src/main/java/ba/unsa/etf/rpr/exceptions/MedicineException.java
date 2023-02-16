package ba.unsa.etf.rpr.exceptions;

/**
 * MedicineException is a custom exception class for handling errors related to medicines.
 * It extends the base Exception class and provides two constructors for creating instances of the exception.
 * @author Semina Muratovic
 */

public class MedicineException extends Exception{

    public MedicineException(String msg, Exception reason){
        super(msg, reason);
    }

    public MedicineException(String msg){
        super(msg);
    }
}
