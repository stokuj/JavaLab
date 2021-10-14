
package pl.polsl.stasica.krystian.view;

import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import pl.polsl.stasica.krystian.controller.*; 
import pl.polsl.stasica.krystian.model.*; 

/** 
 * Class holds basic information about input, output file names and shift value
 * Default values are allready set.
 * 
 * @author Krystian Stasica
 */
public class View {
    /**
     * String representing the input file name.
     * Default value is set.
     */
    public  String inputFile = "infile.txt";
    
    /**
     * String representing the output file name.
     * Default value is set.
     */
    public  String outputFile = "outfile.txt";
    
    /**
     * Intiger representing the shift position.
     * Default value is set to 3.
     */
    public  int shift = 3;
    
    /**
     * String representing shift in reversed order.
     * It will probablly be removed in next version.
     */
    public   boolean isShiftReverse = false;
    
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
