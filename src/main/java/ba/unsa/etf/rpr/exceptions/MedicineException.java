package ba.unsa.etf.rpr.exceptions;

/**
 * MedicineException is a custom exception class for handling errors related to medicines.
 * It extends the base Exception class and provides two constructors for creating instances of the exception.
 * @author Semina Muratovic
 */

public class MedicineException extends Exception{
    /**
     * nstructs a new MedicineException with the specified detail message and cause.
     * @param msg the detail message.
     * @param reason the cause
     */
    public MedicineException(String msg, Exception reason){
        super(msg, reason);
    }

    /**
     * Constructs a new MedicineException with the specified detail message.
     * @param msg the detail message.
     */
    public MedicineException(String msg){
        super(msg);
    }
}
