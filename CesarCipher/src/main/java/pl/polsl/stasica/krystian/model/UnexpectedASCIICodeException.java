
package pl.polsl.stasica.krystian.model;

import javax.swing.JOptionPane;

/**
 * Exception class for objects thrown when unexpected char was found.
 *
 * @author Krystian Stasica
 * @version 0.6
 */
public class UnexpectedASCIICodeException extends Exception{

    /**
     * Non-parameter constructor
     */
    public UnexpectedASCIICodeException() 
    {
        super("Unexped character was found");
        JOptionPane.showMessageDialog(null, "Unexped character was found", "ERROR", JOptionPane.ERROR_MESSAGE);
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
        JOptionPane.showMessageDialog(null, "Unexped character was found: "+ ch +" ASCII Code: "+ xcode
                +"\nLine in code: "+line + "   File: " + str
                + "\nProgram will stop en(de)coding rest of the file", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
