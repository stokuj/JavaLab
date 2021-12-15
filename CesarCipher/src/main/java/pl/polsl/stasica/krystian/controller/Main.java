

package pl.polsl.stasica.krystian.controller;

import pl.polsl.stasica.krystian.model.Model;
import pl.polsl.stasica.krystian.view.View;


/**
 *  Main class of my program. 
 *  Starts controller with parameters in arguments arrayList;
 * 
 * @author Krystian Stasica
 * @version 0.6
 */
class Main{
    
    /**
     * Main method of my program. It creates controller and start it work.
     * 
     * @param arguments parameters/arguments passed to program in console
     */
    public static void main(String... arguments) 
    {
        Model model = new Model("input.txt", "output.txt", "-3");
        View view = new View("GUI - MVC of CisarCipher");
        Controller cObj = new Controller(model, view);
        cObj.initController();
    }
}

