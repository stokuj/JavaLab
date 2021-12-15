
package pl.polsl.stasica.krystian.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;


import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;


/** 
 * Class is used for testing model.
 * 
 * @author Krystian Stasica
 * @version 0.6
 */
public class MyModelTesting {
    
    /**
     *  Testing class constructor
     */
    public MyModelTesting() {
    }
    

    /**
     * Test of getInputFile method, of class Model.
     * 
     * @param expResult default input file
     */
    @ParameterizedTest
    @ValueSource(strings = {"input.txt"}) 
    public void testGetInputFile(String expResult) 
    {
        System.out.println("getInputFile Equals: "+expResult);
        
        Model model = new Model("input.txt", "output.txt", "-3");
        String result = model.getInputFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOutputFile method, of class Model.
     * 
     * @param expResult default output file
     */
    @ParameterizedTest
    @ValueSource(strings = {"output.txt"}) 
    public void testGetOutputFile(String expResult) {
        System.out.println("getOutputFile Equals: "+expResult);
        
        Model model = new Model("input.txt", "output.txt", "-3");
        String result = model.getOutputFile();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShift method, of class Model.
     * 
     * @param expResult default shift
     */
    @ParameterizedTest
    @ValueSource(ints = {-3}) 
    public void testGetShift(int expResult) {
        System.out.println("getShift Equals: "+ expResult);
        
        Model model = new Model("input.txt", "output.txt", "-3");
        int result = model.getShift();
        assertEquals(expResult, result);  
    }
    
///////////////////////////////////////////////////////////////////////

    /**
     * Test of setInputFile method, of class Model.
     * 
     * @param str string being passed for testing(seter)
     */
    @ParameterizedTest
    @ValueSource(strings = {"a.txt","1.txt",""}) 
    public void testSetInputFile(String str) {
        System.out.println("setInputFile Equals: " + str);
        
        Model model = new Model("input.txt", "output.txt", "-3");
        model.setInputFile(str);
        assertEquals(str,model.getInputFile());
    }

    /**
     * Test of setOutputFile method, of class Model.
     * 
     * @param str string being passed for testing(seter)
     */
    @ParameterizedTest
    @ValueSource(strings = {"a.txt","1.txt",""})
    public void testSetOutputFile(String str) {
        System.out.println("setOutputFile Equals: " + str);
        
        Model model = new Model("input.txt", "output.txt", "-3");
        model.setOutputFile(str);
        assertEquals(str,model.getOutputFile());
    }

    /**
     * Test of setShift method, of class Model.
     * 
     * @param ints int being passed for testing(seter)
     */
    @ParameterizedTest
    @ValueSource(ints = {30,3,2,0,-2,-3,-30})
    public void testSetShift(int ints) {
        System.out.println("setShift Equals: " +ints);
        
        Model model = new Model("input.txt", "output.txt", "-3");
        model.setShift(ints);
        assertEquals(ints,-model.getShift());
    }
    
///////////////////////////////////////////////////////////////////////

    /**
     * Test of setShift method, of class Model.NotEquals assumptio
     * Default is NOT Equals
     * 
     * @param ints int being passed for testing(seter)
     */
    @ParameterizedTest
    @ValueSource(ints = {30,3,2,1,-2,-3,-30})
    public void testSetShiftNotEquals(int ints) {
        System.out.println("setShift NotEquals: " + ints);
        
        Model model = new Model("input.txt", "output.txt", "-3");
        model.setShift(ints);
        assertNotEquals(ints,model.getShift());
    }


///////////////////////////////////////////////////////////////////////  
    /**
     * Test of cipher method, of class Model.
     * 
     * @param str string used for testing ( encryption)
     * @param shift shift used for testing ( encryption)
     * @throws java.lang.Exception throwable exception
     */
    @ParameterizedTest
    @CsvSource({"LMNO, 15", "OPQR, 12","RSTU, 9","UVWX, 6","XYZA, 3", "DEFG, -3", "EFGH, -30"})
    public void testCipher(String str, int shift) throws Exception {
        try{
            System.out.println("cipher Equals: "+str);

            Model model = new Model("input.txt", "output.txt", "-3");
            String expResult = "ABCD";
            String result = model.cipher(str, -shift);
            assertEquals(expResult, result); 
        }
        catch(UnexpectedASCIICodeException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Test of cipher method, of class Model.
     * Should Not be equal
     * 
     * @param str string used for testing ( encryption)
     * @param shift shift used for testing ( encryption)
     * @throws java.lang.Exception throwable exception
     */
    @ParameterizedTest
    @CsvSource({"LMNO, 11", "OPQR, 15","RSTU, 6","UVWX, 3","XYZA, 12", "DEFG, 3", "EFGH , -12"})
    public void testCipherNotEquals(String str, int shift) throws Exception {
        System.out.println("cipher NOT Equals: "+ str);
        
        Model model = new Model("input.txt", "output.txt", "-3");
        String expResult = "ABCD";
        String result = model.cipher(str, -shift);
        assertNotEquals(expResult, result);
    }
    
    

    /**
     * Method sends stream of arguments( parameters) to checkParameters test
     * 
     * @return Stream   stream list of parameters
     */ 
    private static Stream<Arguments> sendParametersMethod() {
    return Stream.of(
            Arguments.of((Object) new String[]{"-o", "NOToutput.txt", "-i", "NOTinput.txt", "-s", "5"}),
            Arguments.of((Object) new String[]{"-i", "NOTinput.txt" , "-s", "4"           , "-o", "NOToutput.txt"}),
            Arguments.of((Object) new String[]{"-o", "NOToutput.txt", "-i", "NOTinput.txt", "-s", "2"}),
            Arguments.of((Object) new String[]{"-o", "out.txt"      , "-i", "in.txt"      , "-s","-5"})
        );
    }
    
    /**
     * Test of encode method, of class Model.
     * 
     * @param list Stream of arraylist passed for testing by sendArrayListMethod
     * @throws java.lang.Exception throws exception
     */
    @ParameterizedTest
    @MethodSource("sendArrayListMethod")
    public void testEncode(ArrayList<String> list) throws Exception {
        try
        {
            System.out.println("encode Equals");

            int shift = -3;
            Model model = new Model("input.txt", "output.txt", "-3");

            ArrayList<String> expResult = new ArrayList<>();
            expResult.add("Lorem Ipsum");
            expResult.add("is simply dummy text of the printing and typesetting");

            ArrayList<String> result = model.encode(list, shift);
            assertEquals(expResult, result);     
        }
        catch(UnexpectedASCIICodeException ex) {
            System.out.println(ex);
        }
    }
        
    /**
     * Method sends stream of strings to test encode.
     * 
     * @return Stream.of(test,two);   steam of arraylist bo be tested
     */
    private static Stream <ArrayList<String>> sendArrayListMethod(){
        ArrayList<String> test = new ArrayList<>();
        
        test.add("Iląobj Fmprj");
        test.add("fp pfjmiv arjjv qbuq lc qeb mofkqfkd xka qvmbpbqqfkd");
        
        return Stream.of(test);
    }
    

}
