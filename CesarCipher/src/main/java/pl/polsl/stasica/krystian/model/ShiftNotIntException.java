
package pl.polsl.stasica.krystian.model;

import javax.swing.JOptionPane;

/**
 * Exception class for objects thrown when shift was not intiger type
 *
 * @author Krystian Stasica
 * @version 0.6
 */
public class ShiftNotIntException extends Exception {

    /**
     * Non-parameter constructor
     */
    public ShiftNotIntException() 
    {
        super("Given shift is not an intiger!\n"
                + "Shift is being changed to 3.");
        JOptionPane.showMessageDialog(null, "Given shift is not an intiger!\n"
                + "Shift is being changed to 3.", "ERROR", JOptionPane.ERROR_MESSAGE);
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