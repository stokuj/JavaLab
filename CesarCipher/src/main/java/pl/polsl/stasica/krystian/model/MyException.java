
package pl.polsl.stasica.krystian.model;

/**
 * Exception class for objects thrown when attempting to divide by zero.
 *
 * @author Gall Anonim
 * @version 1.1
 */
public class MyException extends Exception {

    /**
     * Non-parameter constructor
     */
    public MyException() {
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    public MyException(String errorMessage) {
    super(errorMessage);
    }
}