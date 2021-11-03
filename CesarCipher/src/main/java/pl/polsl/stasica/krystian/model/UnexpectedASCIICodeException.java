
package pl.polsl.stasica.krystian.model;

/**
 * Exception class for objects thrown when unexpected char was found.
 *
 * @author Krystian Stasica
 * @version 0.2
 */
public class UnexpectedASCIICodeException extends Exception{

    /**
     * Non-parameter constructor
     */
    public UnexpectedASCIICodeException() 
    {
        super("Unexped character was found");
    }
    
    /**
     * Exception class constructor
     *
     * @param c charater that is invalid
     * @param x character in asci code as intiger
     * @param l number of code line
     * @param s file name of error 
     */
    public UnexpectedASCIICodeException(char c, int x,int l,String s) 
    {   
        super("Unexped character was found: "+ c +" ASCII Code: "+ x
                +"\nLine in code: "+l + "   File: " + s
                + "\nProgram will stop en(de)coding rest of the file");
    }
}
