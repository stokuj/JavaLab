/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stasica.Krystian;

import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/** 
 * Class manages Cipher operation.
 * 
 * @author Krystian Stasica
 * @version 0.2
 */
public class Main 
{
    /**
     * Main method
     * 
     * @param arguments program call parameters
     */
    public static void main(String... arguments){
        
        // Each element is string representing text line.
        ArrayList<String> lines = new ArrayList<>();

        // Default and basic file data. Input, output, shift.
        fileData data = new fileData();

        //We look for expected parameters. We modify data.
        checkParameters(arguments,data);
           
        // Main part of the program
        readToFile(lines, data.inputFile);
        lines = encode(lines,data.shift);
        loadToFile(lines, data.outputFile);
      }
    
    /**
     * Method reads data from given file to an array list.
     * 
     * @param lines - array list of text rows
     * @param input - input file name
     */
    public static void readToFile(ArrayList<String> lines, String input ){


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
    public static void loadToFile(ArrayList<String> lines, String output){
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

    /**
     * Method encodes/decodes arraylist and returnd it.
     * 
     * @param lines - arraylist of text rows
     * @param shift - intiger representing shift of each character.
     * @return lines - modified arraylist
     */
    public static ArrayList<String> encode(ArrayList<String> lines,int shift){
        try
        {
            for(int i=0; i<lines.size(); i++)
            {
                lines.set(i,cipher(lines.get(i),shift));
            }
        }
        catch (Exception e) 
        {
                System.out.println("An error occurred during Encoding.");
                e.printStackTrace();
        }

        return lines;
    }  

    /**
     * Method ciphers given string (row).
     * 
     * @param str - given string to be ciphered
     * @param shift - intiger representing shift of each character.
     * @return s - modified string
     */
    public static String cipher(String str, int shift){
   
        String tmp = "";
             
        for(int i = 0; i < str.length(); i++)
        {
            char c = (char)(str.charAt(i));

            if( c >= 65 & c <=90  & shift > 0) // A-Z shift to left
            {
                c = (char)(c - shift);
                    if( c < 65)
                        c += 26;
                tmp += c;
            }
            else if( c >= 65 & c <=90 & shift < 0) // A-Z shift to right
            {
              c = (char)(c - shift);
                    if( c > 90)
                        c -= 26;
                tmp += c;
            }
            else if( c >= 97 & c <=122 & shift > 0) // A-Z shift to left
            {
               c = (char)(c - shift);
                    if( c < 97)
                        c += 26;

                tmp += c;
            }
            else if( c >= 97 & c <=122 & shift < 0) // A-Z shift to right
            {
              c = (char)(c - shift);
                    if( c > 122)
                        c -= 26;
                tmp += c;
            }
            else
                tmp += (char)(str.charAt(i)); 
        }
        return tmp;
    }
    
    /**
     *
     * @param a
     * @param in
     * @param out
     * @param isShiftReverse
     * @param shift
     * @param data
     */
    public static void checkParameters(String[] a,fileData data )
    {
        //This part of codes looks for parameters
        for(int i=0; i<a.length;i++)
        {   
            if(a[i].equals("-i"))
            {
                data.inputFile=a[i+1];
                i++;
            }
            else if(a[i].equals("-o"))
            {
                data.outputFile=a[i+1];
                i++;
            }
            else if(a[i].equals("-s"))
            {
                data.shift = Integer.parseInt(a[i+1]);
                i++;
            }
            else if(a[i].equals("-r"))
            {
                data.isShiftReverse = true;
            }
        }
        
        data.shift = 0 - data.shift; //for correctness
        data.shift = data.shift%26;
        
        // Do we decode? Shift to the right instead of the left.
        if(data.isShiftReverse)// should be true when reversed
        {
            data.shift = 0 - data.shift;
        }
    }
}

