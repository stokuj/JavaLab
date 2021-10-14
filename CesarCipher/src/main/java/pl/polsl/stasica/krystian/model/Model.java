
package pl.polsl.stasica.krystian.model;

import pl.polsl.stasica.krystian.view.View;
import java.util.ArrayList;
import pl.polsl.stasica.krystian.controller.*; 
import pl.polsl.stasica.krystian.view.*; 

/** 
 * Class simly has methods that operate on files, perform encodeing, algorithm for cipher.
 * 
 * Default values are allready set.
 * @author dv6
 */
public class Model {
    
    /**
     * Method encodes/dencodes arraylist and return it.
     * 
     * @param lines arraylist of text rows
     * @param shift intiger representing shift of each character
     * @return l    modified arraylist is being returned
     */
    public static ArrayList<String> encode(ArrayList<String> l,int shift){
        try
        {
            for(int i=0; i<l.size(); i++)
            {
                l.set(i,cipher(l.get(i),shift));
            }
        }
        catch (Exception e) 
        {
                System.out.println("An error occurred during Encoding.");
                e.printStackTrace();
        }

        return l;
    }  
    
    /**
     * Method ciphers given string (row).
     * 
     * @param str - given string to be ciphered
     * @param shift - intiger representing shift of each character
     * @return tmp - modified string
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
     * Method is looking for parameters, and midfify data object.
     *
     * @param a     arrayList of lines, out text to be encoded
     * @param data  object with input, output, shift configuration
     */
    public static void checkParameters(String[] a,View data )
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

