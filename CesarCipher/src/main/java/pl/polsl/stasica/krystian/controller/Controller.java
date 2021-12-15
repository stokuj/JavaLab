package pl.polsl.stasica.krystian.controller;

import pl.polsl.stasica.krystian.model.Model;
import pl.polsl.stasica.krystian.view.View;
import java.io.IOException;
import java.util.ArrayList;
import pl.polsl.stasica.krystian.model.EmptyFileNameException;
import pl.polsl.stasica.krystian.model.FileNotFoundErrorException;
import pl.polsl.stasica.krystian.model.ShiftNotIntException;
import pl.polsl.stasica.krystian.model.UnexpectedASCIICodeException;
import javax.swing.JOptionPane;
/** 
 * Class performs controlling operator over model and view classes.
 * 
 * @author Krystian Stasica
 * @version 0.6
 */
public class Controller 
{   
    // All testing variables are used to separate prototype of user interface from core program.
    
    private int cnt = 0;
    
    /**
     *  Model object representing model class.
     */
    Model modelObj; 

    /**
     *  View object representing view class
     */
    View viewObj;
    
    /**
     * Controller constructor.Creates Model and View with defeult parameters given in main
     *
     * @param model our model
     * @param view  out view
     */
    public Controller(Model model, View view) {
     modelObj = model;
     viewObj = view;
     initView();
    }
    
    /**
     * View class initialisation
     * 
     */
    public void initView() 
    {
        //viewObj.getInputTextfield().setText(modelObj.getInputFileTest());
        //viewObj.getOutputTextfield().setText(modelObj.getOutputFileTest());
        //viewObj.getShiftTextfield().setText(modelObj.getShiftTest());
    }
    
    /**
     * Method is Actioner, Listener for GUI
     * 
     */
    public void initController() 
    {
        viewObj.getStart().addActionListener(e -> myStart());
        viewObj.getInfo().addActionListener(e -> printInfo());
        viewObj.getVersion().addActionListener(e -> printVersion());
        viewObj.getExit().addActionListener(e -> myExit());
    }
    
    
    private void printVersion(){
        JOptionPane.showMessageDialog(null, "Cesair Cipher, version 0.6", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void printInfo(){
        JOptionPane.showMessageDialog(null, "Cesair Cipher - Krystian Stasica", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * After button is pressed, input data will be saved.
     * 
     */
    private void saveSetInputFileTest() 
    {
        modelObj.setInputFile(viewObj.getInputTextfield().getText());
        JOptionPane.showMessageDialog(null, "Input filename saved : " + modelObj.getInputFile(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * After button is pressed, output data will be saved.
     * 
     */
    private void saveSetOutputFileTest()
    {
        modelObj.setOutputFile(viewObj.getOutputTextfield().getText());
        JOptionPane.showMessageDialog(null, "Output filename saved : " + modelObj.getOutputFile(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * After button is pressed, shift data will be saved.
     * 
     */
    private void saveShiftFileTest()
    {   
        modelObj.setShiftTest(viewObj.getShiftTextfield().getText());
        JOptionPane.showMessageDialog(null, "Shift saved : " + modelObj.getShiftTest(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    /**
     * Start button code, here cipher should start performence
     * 
     */
    private void myStart() 
    {
        saveSetInputFileTest();
        saveSetOutputFileTest();
        saveShiftFileTest();
        start();
        cnt +=1;
        viewObj.vHistory(cnt,modelObj.getInputFile(),modelObj.getOutputFile(),modelObj.getShift());
    }
    
    /**
     * Exit button code
     * 
     */
    private void myExit() 
    {
        JOptionPane.showMessageDialog(null, "Program will end now", "Info", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
//////////////////////////////////////////////////////////////////////////////// 
    /**
     * Method represents starting of an program.
     * It controls most part program.
     * Manages controller operation ofr view and model.
     * t
     */
     public void start(){
         if(viewObj.getDecodeStatus())
             modelObj.setShift(modelObj.getShift());

        // Each element is string representing text line.
        ArrayList<String> lines = new ArrayList<>();

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
} 




    
