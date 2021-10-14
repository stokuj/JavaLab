package pl.polsl.stasica.krystian.controller;

import pl.polsl.stasica.krystian.model.Model;
import pl.polsl.stasica.krystian.view.View;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import pl.polsl.stasica.krystian.model.*; 
import pl.polsl.stasica.krystian.view.*; 
/** 
 * Class manages Cipher operation.
 * 
 * @author Krystian Stasica
 * @version 0.2
 */
public class Controller 
{
    /**
     * Controller method
     * 
     * @param arguments program call parameters
     */
    public static void main(String... arguments){
        
        // Each element is string representing text line.
        ArrayList<String> lines = new ArrayList<>();

        // Default and basic file data. Input, output, shift.
        View dataView = new View();
        Model model = new Model();

        //We look for expected parameters. We modify data.
        model.checkParameters(arguments,dataView);
           
        // Main part of the program
        dataView.readToFile(lines, dataView.inputFile);
        lines = model.encode(lines,dataView.shift);
        dataView.loadToFile(lines, dataView.outputFile);
      }
} 





    
