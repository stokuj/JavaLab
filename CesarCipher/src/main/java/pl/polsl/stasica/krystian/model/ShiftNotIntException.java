
package pl.polsl.stasica.krystian.model;

/**
 * Exception class for objects thrown when attempting to divide by zero.
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class ShiftNotIntException extends Exception {

    /**
     * Non-parameter constructor
     */
    public ShiftNotIntException() 
    {
        super("Given shift is not an intiger!\n"
                + "Shift is being changed to 3.");
    }

    /**
     * Exception class constructor
     *
     * @param errorMessage display message
     */
    public ShiftNotIntException(String errorMessage) 
    {
        super(errorMessage);
    }
}