package pl.polsl.stasica.krystian.controller;

import pl.polsl.stasica.krystian.model.Model;
import pl.polsl.stasica.krystian.view.View;
import java.io.IOException;
import java.util.ArrayList;
import pl.polsl.stasica.krystian.model.EmptyFileNameException;
import pl.polsl.stasica.krystian.model.FileNotFoundErrorException;
import pl.polsl.stasica.krystian.model.ShiftNotIntException;
import pl.polsl.stasica.krystian.model.UnexpectedASCIICodeException;

/** 
 * Class performs controlling operator over model and view classes.
 * 
 * @author Krystian Stasica
 * @version 0.3
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
            if(userWantsDefaultParameters)  
                modelObj.useDefaultParameters();    // user wants use default parameters 
            else                                    
                takeDataFromUser(modelObj,viewObj);         // user wants input filenames
        }
        else    // if user provided parameters    
            modelObj.checkParameters(arguments);   

        // Main part of the program read, encode and load.
        try{
            viewObj.readToFile(lines, modelObj.getInputFile());
            lines = modelObj.encode(lines,modelObj.getShift());
            viewObj.loadToFile(lines, modelObj.getOutputFile());
        }
        catch(IOException | FileNotFoundErrorException | UnexpectedASCIICodeException ex) {
            
           viewObj.displayException(ex);
        }
    }

    /**
     * Method taked data from user (by view) and saves it to the model object
     *
     * @param view  view object is used for comunication with user.
     * @param model model object holds data about input, output, shift
     */
    public void takeDataFromUser(Model model, View view){
        try{
            model.setInputFile(view.askForInput()); 
        }   
        catch (EmptyFileNameException ex){
            viewObj.displayException(ex);
        }
        

        try{
            model.setOutputFile(view.askForOutput()); 
        }
        catch (EmptyFileNameException ex){
            viewObj.displayException(ex);
        }
        
        
        try{
            model.setShift(view.askForShift());
        }
        catch (ShiftNotIntException ex){
            viewObj.displayException(ex);
        }
    }
} 




    
