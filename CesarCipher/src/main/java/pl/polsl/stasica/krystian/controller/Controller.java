package pl.polsl.stasica.krystian.controller;

import pl.polsl.stasica.krystian.model.Model;
import pl.polsl.stasica.krystian.view.View;
import java.util.ArrayList;

/** 
 * Class performs controlling operator over model and view classes.
 * 
 * @author Krystian Stasica
 * @version 0.2
 */
public class Controller 
{
    Model graph; 
    View view;
    
    /**
     * Basic Controller constructor.
     * Creates Model and View.
     * 
     */
    public Controller(){
        this.graph = new Model(); 
        this.view = new View();
    }
    
    /**
     * Method represents starting of an program.
     * It controls most part program.
     * Manages controller operation ofr view and model.
     * 
     */
     public void start(String... arguments){
        // Default and basic file data. Input, output, shift.
        View view = new View();
        Model model = new Model();
        
        // This part will print basic program informa
        view.basicInfo();
        
        // Each element is string representing text line.
        ArrayList<String> lines = new ArrayList<>();

        //We look for expected parameters. We modify data.
        model.checkParameters(arguments,model);
           
        // Main part of the program
        view.readToFile(lines, model.getInputFile());
        lines = model.encode(lines,model.getShift());
        view.loadToFile(lines, model.getOutputFile());
    }
} 





    
