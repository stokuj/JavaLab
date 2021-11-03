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

    /**
     *  Model object representing model class.
     */
    Model modelObj; 

    /**
     *  View object representing view class
     */
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
        
        // This object will print basic program information
        viewObj.basicInfo();
        
        // Each element is string representing text line.
        ArrayList<String> lines = new ArrayList<>();

        if(arguments.length == 0)   // if user didn't provided parameters
        {
            boolean userWantsDefaultParameters = viewObj.getUserChoiceAboutParameters();
            if(userWantsDefaultParameters)  // user wants use default parameters 
                modelObj.useDefaultParameters(modelObj);    
            else    // user wants input filenames
                modelObj.takeDataFromUser(modelObj,viewObj);    
        }
        else    // if user provided parameters    
            modelObj.checkParameters(arguments,modelObj);   

        // Main part of the program read, encode and load.
        try{
            viewObj.readToFile(lines, modelObj.getInputFile());
            lines = modelObj.encode(lines,modelObj.getShift());
            viewObj.loadToFile(lines, modelObj.getOutputFile());
        }
        catch(IOException e) {
            
           System.out.println(e.getMessage());
        }
    }
} 





    
