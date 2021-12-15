
package pl.polsl.stasica.krystian.model;

import javax.swing.JOptionPane;


/**
 * Exception class for objects thrown when given file was not found.
 *
 * @author Krystian Stasica
 * @version 0.6
 */
public class FileNotFoundErrorException extends Exception {

    /**
     * Non-parameter constructor
     */
    public FileNotFoundErrorException() 
    {
        super("Program was not able to find file.\n"
        + "Please check file path.");
        JOptionPane.showMessageDialog(null, "Program was not able to find file.\n"
        + "Please check file path.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Exception class constructor
     *
     * @param errorMessage  message of our error
     */
    public FileNotFoundErrorException(String errorMessage) 
    {
        super(errorMessage);
    }
}

