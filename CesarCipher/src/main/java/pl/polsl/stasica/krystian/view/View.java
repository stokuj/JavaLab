
package pl.polsl.stasica.krystian.view;

import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


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
        System.out.println("Wecome to Cesar Cipher program.");
        System.out.println("Use -o input.txt to enter input file name.");
        System.out.println("Use -i output.txt to enter output file name.");
        System.out.println("Use shift and intiger to set shift position.");
        System.out.println("For decodeing use negative shift.");
    }
    
    /**
     * Method reads data from given file to an array list.
     * 
     * @param lines - array list of text rows
     * @param input - input file name
     */
    public void readToFile(ArrayList<String> lines, String input ){


        // we create a scanner for reading the file
        try (Scanner scanner = new Scanner(Paths.get(input))) 
        {
            // we read all the lines of the file
            while (scanner.hasNextLine()) 
            {
                lines.add(scanner.nextLine());
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
      }
    
    /**
     * Method loads data to given file from array list.
     * 
     * @param lines - array list of text rows
     * @param output - output file name
     */
    public void loadToFile(ArrayList<String> lines, String output){
        try 
        {
        FileWriter myWriter = new FileWriter(output);

            for(String str: lines) 
            {
                myWriter.write(str + System.lineSeparator());
            }


                //myWriter.write("Files in Java might be tricky, but it is fun enough!");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
        } 
        catch (Exception e) 
        {
                System.out.println("An error occurred.");
                e.printStackTrace();
        }
      }
}
