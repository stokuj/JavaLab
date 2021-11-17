package pl.polsl.stasica.krystian.model;


/**
 * Exception class for objects thrown when given file name is empty string "".
 *
 * @author Krystian Stasica
 * @version 0.3
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
     * @param errorMessage  message of our error
     */
    public EmptyFileNameException(String errorMessage) 
    {
        super(errorMessage);
    }
}
