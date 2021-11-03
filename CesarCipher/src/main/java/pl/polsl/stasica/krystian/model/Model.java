
package pl.polsl.stasica.krystian.model;

import java.util.ArrayList;
import pl.polsl.stasica.krystian.view.View;

/** 
 * Class simly has methods that operate on files, perform encodeing, algorithm for cipher.
 * Default values are allready set.
 * 
 * @author Krystian Stasica
 * @version 0.2
 */
public class Model {
    /**
     * String representing the input file name.
     * Default value is set.
     */
    private  String inputFile = "infile.txt";
    
    /**
     * String representing the output file name.
     * Default value is set.
     */
    private  String outputFile = "outfile.txt";
    
    /**
     * Intiger representing the shift position.
     * Default value is set to 3.
     */
    private  int shift = 3;
    
    /**
     * Basic Model constructor.
     * Creates default values for model class.
     * 
     */
    public Model() {
        inputFile = "infile.txt";
        outputFile = "outfile.txt";
        shift = 3;
    }
    
    /**
     * Method returns private input file name from model.
     * 
     * @return inputFile   input file name
     */
    public String getInputFile() {
        return inputFile;
    }
    
    /**
     * Method returns private output file name from model.
     * 
     * @return outputFile   output file name
     */
    public String getOutputFile() {
        return outputFile;
    }
    
    /**
     * Method returns private shift from model.
     * 
     * @return shift    position of shift in encryption
     */
    public int getShift() {
        return shift;
    }
    
    /**
     * Method encodes/dencodes arraylist and return it.
     * 
     * @param l arraylist of text rows
     * @param shift intiger representing shift of each character
     * @return l    modified arraylist is being returned
     */
    public ArrayList<String> encode(ArrayList<String> l,int shift){
        try
        {
            for(int i=0; i<l.size(); i++)
            {
                l.set(i, cipher(l.get(i),shift) );
            }
        }
        catch (UnexpectedASCIICodeException e) {
            
            System.out.println(e.getMessage());
        }

        return l;
    }  
    
    /**
     * Method ciphers given string (row).
     * 
     * @param str - given string to be ciphered
     * @param shift - intiger representing shift of each character
     * @return tmp - modified string
     * @throws pl.polsl.stasica.krystian.model.UnexpectedASCIICodeException throws exception when unexpected character is being found
     */
    public String cipher(String str, int shift) throws UnexpectedASCIICodeException{
   
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
            else{
                if( c >= 32 & c <=127)
                    tmp += (char)(str.charAt(i)); 
                else
                    throw new UnexpectedASCIICodeException(c,(int)c,143,"model.java");
            }

        }
        return tmp;
    }
    
    /**
     * Method is looking for parameters, and midfify data object.
     *
     * @param a     arrayList of lines, out text to be encoded
     * @param model  object with input, output, shift configuration
     */
    public  void checkParameters(String[] a,Model model ){
        //This part of codes looks for parameters
        for(int i=0; i<a.length;i++)
        {   
            switch (a[i]) {
                case "-i":
                    inputFile =a[i+1];
                    i++;
                    break;
                case "-o":
                    outputFile=a[i+1];
                    i++;
                    break;
                case "-s":
                    shift = Integer.parseInt(a[i+1]);
                    i++;
                    break;
                default:
                    break;
            }
        }
        
        model.shift = 0 - model.shift; //for correctness
        model.shift = model.shift%26;
        
    }
 
    /**
     * Method taked data from user (by view) and saves it to the model object
     *
     * @param view  view object is used for comunication with user.
     * @param model model object holds data about input, output, shift
     */
    public void takeDataFromUser(Model model, View view){
        model.inputFile     = view.askForInput();
        model.outputFile    = view.askForOutput();
        model.shift         = view.askForShift();
        model.shift = 0 -model.shift; // for corectness 
    }
    
    /**
     * Method sets default parameter-like values for input, output, shift.
     *
     * @param model model object holds data about input, output, shift
     */
    public void useDefaultParameters(Model model){
        inputFile = "infile.txt";
        outputFile = "outfile.txt";
        shift = -3;
    }
}

