
package pl.polsl.stasica.krystian.view;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


import pl.polsl.stasica.krystian.model.ShiftNotIntException;
import pl.polsl.stasica.krystian.model.EmptyFileNameException;
import pl.polsl.stasica.krystian.model.FileNotFoundErrorException;

/** 
 * Class holds basic information about input, output file names and shift value
 * Default values are allready set.
 * 
 * @author Krystian Stasica
 * @version 0.2
 */
public class View {

    /**
     * Method prints basic information for user.
     * 
     */
    public void basicInfo(){
        System.out.println("Wecome to Cesar Cipher program.\n");
        
        System.out.println("Program can take following arguments");
        System.out.println("or can ask user for input if no arguments are detected.\n");

        System.out.println("Use -o input.txt to enter input file name.");
        System.out.println("Use -i output.txt to enter output file name.");
        System.out.println("Use -s and intiger to set shift position.");
        System.out.println("For decodeing use negative shift.");
        System.out.println("-i infile.txt -o outfile.txt -s -3\n");
    }

   /**
     * Method taked input from user and return it to controller.
     *
     * @return given input by user or default value
     */
    public String askForInput(){
        try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Please enter your input file in txt format.");
            String name = sc.nextLine();
            
            if(name.equals(""))
                throw new EmptyFileNameException();

            return name;
        }
        catch (EmptyFileNameException ex){
            
            System.out.println(ex.getMessage());
        }

        return "infile.txt";
    }
    
   /**
     * Method taked output from user and return it to controller.
     *
     * @return given output by user or default value
     */
    public String askForOutput(){
       try{
            Scanner sc=new Scanner(System.in);
            System.out.println("Please enter your output file in txt format.");
            String name = sc.nextLine();
            
            if(name.equals(""))
                throw new EmptyFileNameException();

            return name;
        }
        catch (EmptyFileNameException ex){
            
            System.out.println(ex.getMessage());
        }

        return "outfile.txt";
    }
    
    /**
     * Method taked shift from user and returns it to controller.
     *
     * @return given shift by user or default value
     */
    public int askForShift()  {   
        var tmp=0;
        try{
            
            System.out.println("Please enter your shift intiger.");
            Scanner sc=new Scanner(System.in);
            if(sc.hasNextInt())
                tmp=sc.nextInt();
            else
                throw new ShiftNotIntException();

        }
        catch (ShiftNotIntException ex){
            
            System.out.println(ex.getMessage());
        }

        return tmp; // 3 is default value
    }
        
    /**
     * Method reads data from given file to an array list.
     * 
     * @param lines - array list of text rows
     * @param input - input file name
     * @throws java.io.IOException throws when program can't locate path to file
     */
    public void readToFile(ArrayList<String> lines, String input ) throws IOException{
        
        File tempFile = new File(input);
        boolean exists = tempFile.exists();
        
        if(!exists)
            throw new FileNotFoundErrorException();
        
        Scanner scanner = new Scanner(Paths.get(input));

        // we read all the lines of the file
        while (scanner.hasNextLine()) 
        {
            lines.add(scanner.nextLine());
        }
    }     
    
    /**
     * Method loads data to given file from array list.
     * 
     * @param lines - array list of text rows
     * @param output - output file name
     * @throws java.io.IOException throws when program can't locate path to file
     */
    public void loadToFile(ArrayList<String> lines, String output) throws IOException{
        
        File tempFile = new File(output);


        try (FileWriter file = new FileWriter(output)) {
            for(String str: lines)
            {
                file.write(str + System.lineSeparator());
            }
        }
        boolean exists = tempFile.exists();
        if(!exists)
            throw new FileNotFoundErrorException();
        
        System.out.println("Successfully wrote to the file.");
    }
    
    
    /**
     * Method returns user choice about using default parameters.
     * 
     * @return returned boolean represents user intence
     */
    public boolean getUserChoiceAboutParameters(){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to use default parameters?");    
        System.out.println("Write y/yes if so, or n/no if u want to input data.");
        
        boolean stopLoop = false;
        boolean userWantsDefaultParameters = false;
        
        while(!stopLoop)
        {
            String str= sc.nextLine();
            switch (str) {
                case "y":
                case "yes":
                    userWantsDefaultParameters = true;
                    stopLoop = true;
                    break;
                case "n":
                case "no":
                    userWantsDefaultParameters = false;
                    stopLoop = true;
                    break;
                default:
                    System.out.println("Wrong choice. Select again!");
                    break;
            }
        }

        return userWantsDefaultParameters;
    }
}
