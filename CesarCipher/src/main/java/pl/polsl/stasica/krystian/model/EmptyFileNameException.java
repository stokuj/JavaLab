package pl.polsl.stasica.krystian.model;

import javax.swing.JOptionPane;


/**
 * Exception class for objects thrown when given file name is empty string "".
 *
 * @author Krystian Stasica
 * @version 0.6
 */
public class EmptyFileNameException extends Exception {
    
    
    /**
     * Non-parameter constructor
     */
    public EmptyFileNameException() 
    {   
        super("Given filename is incorrect\n"
                + "filename is being changed to default value.");
        JOptionPane.showMessageDialog(null, "Given filename is incorrect\n"
                + "filename is being changed to default value.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Exception class constructor
     *
     * @param errorMessage  message of our error
     */
    public EmptyFileNameException(String errorMessage) 
    {
        super(errorMessage);
    }
}
