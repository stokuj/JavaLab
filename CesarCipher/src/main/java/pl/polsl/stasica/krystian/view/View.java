
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
     * Method prints basic information of user.
     * 
     */
    public void basicInfo(){
        System.out.println("Wecome to Cesar Cipher program.\n");

        System.out.println("Use -o input.txt to enter input file name.");
        System.out.println("Use -i output.txt to enter output file name.");
        System.out.println("Use -s and intiger to set shift position.");
        System.out.println("For decodeing use negative shift.");
        System.out.println("-i infile.txt -o outfile.txt -s -3\n");
    }

    public String askForInput()
    {
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
    
    public String askForOutput()
    {
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
    
    public int askForShift()
    {   
        int tmp=0;
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

        return 3; // 3 is default value
    }
    
        
    /**
     * Method reads data from given file to an array list.
     * 
     * @param lines - array list of text rows
     * @param input - input file name
     * @throws java.io.IOException
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
     * @throws java.io.IOException
     */
    public void loadToFile(ArrayList<String> lines, String output) throws IOException{
        
        try (FileWriter file = new FileWriter(output)) {
            for(String str: lines)
            {
                file.write(str + System.lineSeparator());
            }
        }
        System.out.println("Successfully wrote to the file.");

    }
    
    public boolean getUserChoiceAboutParameters(){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to use default parameters?");    
        System.out.println("Write y/yes if so, or n/no if u want to input data.");
        
        boolean stopLoop = false;
        boolean userWantsDefaultParameters = false;
        
        while(!stopLoop)
        {
            String str= sc.nextLine();
            if(str.equals("y")||str.equals("yes"))
            {
                userWantsDefaultParameters = true;
                stopLoop = true;
            }
            else if(str.equals("n")||str.equals("no"))
            {
                userWantsDefaultParameters = false;
                stopLoop = true;
            }
            else
                System.out.println("Wrong choice. Select again!");
        }

        return userWantsDefaultParameters;
    }
}
