
package pl.polsl.stasica.krystian.model;


/**
 * Exception class for objects thrown when attempting to divide by zero.
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class EmptyFileNameException extends Exception {

    /**
     * Non-parameter constructor
     */
    public EmptyFileNameException() 
    {
        super("Given filename is incorrect\n"
                + "filename is being changed to default value.");
    }

    /**
     * Exception class constructor
     *
     * @param errorMessage
     */
    public EmptyFileNameException(String errorMessage) 
    {
        super(errorMessage);
    }
}
