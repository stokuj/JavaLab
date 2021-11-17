
package pl.polsl.stasica.krystian.model;

import java.util.ArrayList;
import java.util.stream.Stream;


import org.junit.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.provider.*;



/** 
 * Class is used for testing model.
 * 
 * @author Krystian Stasica
 * @version 0.3
 */
public class MyModelTesting {
    
    public MyModelTesting() {
    }
    

    @BeforeEach
    public void setUp() {
        //  Model model = new Model();
    }

    /**
     * Test of getInputFile method, of class Model.
     */
    @Test
    public void testGetInputFile() 
    {
        System.out.println("getInputFile");
        
        Model model = new Model();
        String expResult = "infile.txt";
        String result = model.getInputFile();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getOutputFile method, of class Model.
     */
    @Test
    public void testGetOutputFile() {
        System.out.println("getOutputFile");
        
        Model model = new Model();
        String expResult = "outfile.txt";
        String result = model.getOutputFile();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getShift method, of class Model.
     */
    @Test
    public void testGetShift() {
        System.out.println("getShift");
        
        Model model = new Model();
        int expResult = 3;
        int result = model.getShift();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setInputFile method, of class Model.
     */
    @ParameterizedTest
     @ValueSource(strings = {"a"}) 
    public void testSetInputFile(String str) {
        System.out.println("setInputFile");
        
        Model model = new Model();
        model.setInputFile(str);
        
    }

    /**
     * Test of setOutputFile method, of class Model.
     */
    @ParameterizedTest
    @ValueSource(strings = {})
    public void testSetOutputFile(String str) {
        System.out.println("setOutputFile");
        /*
        Model model = new Model();
        model.setOutputFile(str);
        */
    }

    /**
     * Test of setShift method, of class Model.
     */
    @ParameterizedTest
    @ValueSource(ints = {})
    public void testSetShift(int ints) {
        System.out.println("setShift");
        /*
        Model model = new Model();
        model.setShift(ints);
        */
    }

    /**
     * Test of cipher method, of class Model.
     */
    //@Test
    @ParameterizedTest
    @CsvSource({
        "Test, 3",
        "Test, 0"})
    public void testCipher(String str, int shift) throws Exception {
        System.out.println("cipher");
        /*
        Model model = new Model();
        String expResult = "";
        String result = model.cipher(str, shift);
        assertEquals(expResult, result);
        */
    }

    /**
     * Test of useDefaultParameters method, of class Model.
     */
    @Test
    public void testUseDefaultParameters() {
        System.out.println("useDefaultParameters");
        
        Model model = new Model();
        model.useDefaultParameters();
        
    }

    /**
     * Test of checkParameters method, of class Model.
     */
    @ParameterizedTest
    @MethodSource("sendParametersMethod")
    public void testCheckParameters(String... arg) {
        System.out.println("checkParameters");
        /*
        Model model = new Model();
        model.checkParameters(arr);
        */
    }
    
    /**
     * Test of encode method, of class Model.
     */
    @ParameterizedTest
    @MethodSource("sendArrayListMethod")
    public void testEncode(ArrayList<String> list) throws Exception {
        System.out.println("encode");
        /*
        int shift = 3;
        Model model = new Model();
        ArrayList<String> result = model.encode(list, shift);
        assertEquals(expResult, result);
        */
    }
    
    /**
     * Method sends stream of arguments( parameters) to checkParameters test
     * 
     * @return listWithArguments.stream()   stream list of parameters
     */ 
    /*private static Stream<Arguments> sendParametersMethod(){
        List listWithArguments = List.of(
                Arguments.of({"-o", "outputfile.txt", "-i", "infile.txt", "-s", "3"}"),
                Arguments.of({"-i", "infile.txt", "-o", "outputfile.txt", "-s", "3"}"),
                Arguments.of({"-s", "3", "-o", "outputfile.txt", "-i", "infile.txt"}),
                Arguments.of({""})
        return listWithArguments.stream();
    }
    */
    
    
    /**
     * Method sends stream of strings to test encode.
     * 
     * @return listWithArguments.stream()   string stream to be tested
     */ 
    /*private static ArrayList<String> sendArrayListMethod(){
        List listWithArguments = List.of(
                Arguments.of({"Test", "Test2", "abcd", "ąe", "", "333d"}"),
                Arguments.of({"Abcd", "Łąd", "23ee", "Abcd dtest", "", ";"}"),
                Arguments.of({""})
        return listWithArguments.stream();
    }
    */
}
