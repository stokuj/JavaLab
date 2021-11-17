

package pl.polsl.stasica.krystian.controller;

/**
 *  Main class of my program. 
 *  Starts controller with parameters in arguments arrayList;
 * 
 * @author Krystian Stasica
 * @version 0.3
 */
class Main{
    
    /**
     * Main method of my program. It creates controller and start it work.
     * 
     * @param arguments parameters/arguments passed to program in console
     */
    public static void main(String... arguments)
    { 
       Controller cObj = new Controller();  
       cObj.start(arguments); 
    } 
}

