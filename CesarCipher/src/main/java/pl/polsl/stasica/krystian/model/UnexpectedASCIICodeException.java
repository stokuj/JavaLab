
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
     * @param ch charater that is invalid
     * @param xcode character in asci code as intiger
     * @param line number of code line
     * @param str file name of error 
     */
    public UnexpectedASCIICodeException(char ch, int xcode,int line,String str) 
    {   
        super("Unexped character was found: "+ ch +" ASCII Code: "+ xcode
                +"\nLine in code: "+line + "   File: " + str
                + "\nProgram will stop en(de)coding rest of the file");
    }
}
