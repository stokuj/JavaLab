
package pl.polsl.stasica.krystian.model;

import java.util.ArrayList;


/** 
 * Class simly has methods that operate on files, perform encodeing, algorithm for cipher.
 * Default values are allready set.
 * 
 * @author Krystian Stasica 
 * @version 0.6
 */
public class Model 
{   
    // All testing variables are used to separate prototype of user interface from core program.
    
    private boolean isDecode = false;
    /**
     * String representing the input file name.
     * Default value is set.
     */
    private  String inputFile;
    
    /**
     * String representing the output file name.
     * Default value is set.
     */
    private  String outputFile;
    
    /**
     * Intiger representing the shift position.
     * Default value is set to 3.
     */
    private  int shift;
    
    /**
     * Testing shift representing the input file name.
     */
    public String shiftTest;

    /**
     * Model constructor used to pass default values in ui
     * 
     * @param inputFileTest testing input variable used in ui
     * @param outputFileTest testing output variable used in ui
     * @param shiftTest testing shift variable used in ui
     */
    public Model(String inputFileTest, String outputFileTest, String shiftTest) 
    {
        this.inputFile = inputFileTest;
        this.outputFile = outputFileTest;
        this.shiftTest = shiftTest;
        this.shift = Integer.parseInt(shiftTest);
    }

 
    
    /**
     * Getter of getShiftTest
     * 
      @return getShiftTest   shift
     */
    public String getShiftTest() 
    {
        return shiftTest;
    }
    
    /**
     * Setter of setShiftTest
     * 
      @param str   shiftTest
     */
    public void setShiftTest(String str) 
    {
        this.shiftTest = str;
        this.shift = Integer.parseInt(shiftTest); 
    }
////////////////////////////////////////////////////////////////////////////////   


    
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
       
        //list.forEach(name -> list.set(list.indexOf(name), cipher(name, shift)));
        
        
        // for-each loop 
        for(String str: list)
        {
            list.set(list.indexOf(str), cipher(str, shift));
        }
        
        // for-each loop for printing encoded text
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
        if(str.isEmpty())
            return tmp;
                
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
}
