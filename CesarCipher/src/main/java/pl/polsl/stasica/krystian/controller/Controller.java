package pl.polsl.stasica.krystian.controller;

import pl.polsl.stasica.krystian.model.Model;
import pl.polsl.stasica.krystian.view.View;
import java.io.IOException;
import java.util.ArrayList;

/** 
 * Class performs controlling operator over model and view classes.
 * 
 * @author Krystian Stasica
 * @version 0.2
 */
public class Controller 
{
    Model modelObj; 
    View viewObj;
    
    /**
     * Basic Controller constructor.
     * Creates Model and View.
     * 
     */
    public Controller(){
        this.modelObj = new Model(); 
        this.viewObj = new View();
    }
    
    /**
     * Method represents starting of an program.
     * It controls most part program.
     * Manages controller operation ofr view and model.
     * 
     * @param arguments loads UI parameters into arrayList
     */
     public void start(String... arguments){
        
        // This part will print basic program information
        viewObj.basicInfo();
        
        // Each element is string representing text line.
        ArrayList<String> lines = new ArrayList<>();

        //We look for expected parameters. We modify data.
        // If user dint used any arguments we will ask him for data.
        boolean userWantsDefaultParameters = false;
        
        userWantsDefaultParameters = viewObj.getUserChoiceAboutParameters();
        
        if(arguments.length == 0)
            if(userWantsDefaultParameters)
                modelObj.useDefaultParameters(modelObj);
            else
                modelObj.takeDataFromUser(modelObj,viewObj);
        else
            modelObj.checkParameters(arguments,modelObj);

        // Main part of the program read, encode and load.
        try{
            viewObj.readToFile(lines, modelObj.getInputFile());
            lines = modelObj.encode(lines,modelObj.getShift());
            viewObj.loadToFile(lines, modelObj.getOutputFile());
        }
        catch(IOException e) {
            
        e.printStackTrace();
        }
    }
} 





    
