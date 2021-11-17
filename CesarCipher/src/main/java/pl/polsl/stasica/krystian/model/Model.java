
package pl.polsl.stasica.krystian.model;

import java.util.ArrayList;


/** 
 * Class simly has methods that operate on files, perform encodeing, algorithm for cipher.
 * Default values are allready set.
 * 
 * @author Krystian Stasica
 * @version 0.3
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
     * Seter for inputFile
     * 
     * @param str   String that will be assigned as inputFile.
     */
    public void setInputFile(String str) {
        inputFile = str;
    }
    
    /**
     * Seter for outputFile
     * 
     * @param str   String that will be assigned as outputFile.
     */
    public void setOutputFile(String str) {
        outputFile = str;
    }
    
    /**
     * Seter for shift
     * 
     * @param in   Int that will be assigned as shift.
     */
    public void setShift(int in) {
        shift = in;
        shift = 0 - shift; // for corectness 
    }
    
    
    /**
     * Method encodes/dencodes arraylist and return it.
     * 
     * @param list arraylist of text rows
     * @param shift intiger representing shift of each character
     * @return list    modified arraylist is being returned
     * @throws pl.polsl.stasica.krystian.model.UnexpectedASCIICodeException throws exception when unexpected character is being found
     */
    public ArrayList<String> encode(ArrayList<String> list,int shift) throws UnexpectedASCIICodeException{
        
        //for(int i=0; i<list.size(); i++)
        //    list.set(i, cipher(list.get(i),shift) );
       
        list.forEach(name -> list.set(list.indexOf(name), cipher(name, shift)));
        
        list.forEach(name -> System.out.println(name));
        
        return list;
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
            char ch = (char)(str.charAt(i));

            if( ch >= 65 & ch <=90  & shift > 0) // A-Z shift to left
            {
                ch = (char)(ch - shift);
                    if( ch < 65)
                        ch += 26;
                tmp += ch;
            }
            else if( ch >= 65 & ch <=90 & shift < 0) // A-Z shift to right
            {
              ch = (char)(ch - shift);
                    if( ch > 90)
                        ch -= 26;
                tmp += ch;
            }
            else if( ch >= 97 & ch <=122 & shift > 0) // A-Z shift to left
            {
               ch = (char)(ch - shift);
                    if( ch < 97)
                        ch += 26;

                tmp += ch;
            }
            else if( ch >= 97 & ch <=122 & shift < 0) // A-Z shift to right
            {
              ch = (char)(ch - shift);
                    if( ch > 122)
                        ch -= 26;
                tmp += ch;
            }
            else{
                if( ch >= 32 & ch <=127)
                    tmp += (char)(str.charAt(i)); 
                else
                    throw new UnexpectedASCIICodeException(ch,(int)ch,143,"model.java");
            }

        }
        return tmp;
    }
    
    /**
     * Method is looking for parameters, and midfify data object.
     *
     * @param arr     arrayList of lines, out text to be encoded
     */
    public  void checkParameters(String[] arr){
        //This part of codes looks for parameters
        for(int i=0; i<arr.length;i++)
        {   
            switch (arr[i]) {
                case "-i":
                    inputFile =arr[i+1];
                    i++;
                    break;
                case "-o":
                    outputFile=arr[i+1];
                    i++;
                    break;
                case "-s":
                    shift = Integer.parseInt(arr[i+1]);
                    i++;
                    break;
                default:
                    break;
            }
        }
        
        shift = 0 - shift; //for correctness
        shift = shift%26;
        
    }
    
    /**
     * Method sets default parameter-like values for input, output, shift.
     *
     */
    public void useDefaultParameters(){
        inputFile = "infile.txt";
        outputFile = "outfile.txt";
        shift = -3;
    }
}

