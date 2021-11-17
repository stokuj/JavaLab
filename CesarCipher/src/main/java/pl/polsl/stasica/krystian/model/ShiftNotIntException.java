
package pl.polsl.stasica.krystian.model;

/**
 * Exception class for objects thrown when shift was not intiger type
 *
 * @author Krystian Stasica
 * @version 0.3
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
     * @param errorMessage  message of our error
     */
    public ShiftNotIntException(String errorMessage) 
    {
        super(errorMessage);
    }
}