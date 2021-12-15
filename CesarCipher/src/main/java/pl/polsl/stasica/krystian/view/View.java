
package pl.polsl.stasica.krystian.view;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import pl.polsl.stasica.krystian.model.FileNotFoundErrorException;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/** 
 * Class holds basic information about input, output file names and shift value
 * Default values are allready set.
 * 
 * @author Krystian Stasica
 * @version 0.6
 */
public class View 
{
    // All testing variables are used to separate prototype of user interface from core program.    
    // Some funtion like printBasicInfo may be changed  into buttons
    
    
    // View uses Swing framework to display UI to user
    
    /**
     *  Main frame of program
     */
    private JFrame frame;
    
    /**
     *  Laber for input file
     */
    private JLabel inputLabel;
    
    /**
     *  Laber for output file
     */
    private JLabel outputLabel;
    
    /**
     *  Laber for shift
     */
    private JLabel shiftLabel;
    
    /**
     *  Textfield for input file
     */
    private JTextField inputTextfield;
    
    /**
     *  Textfield for output file
     */
    private JTextField outputTextfield;
    
    /**
     *  Textfield for shift
     */
    private JTextField shiftTextfield;
    
    /**
     *  Button to save input file
     */
    private JButton inputSaveButton;
    
    /**
     *  Button to save output file
     */
    private JButton outputSaveButton;
    
    /**
     *  Button to save shift
     */
    private JButton shiftSaveButton;
    
    /**
     *  Button to run core program
     */
    private JButton runApp;
    
    /**
     *  Button to exit
     */
    private JButton exit;
    
    /**
     *  Menu bar
     */
    private JMenuBar menuBar;
    
    /**
     *  Element of manu bar - menu
     */
    private JMenu menu;
    
    /**
     *  Element of menu - version
     */
    private JMenuItem menuVersion;
    
    /**
     *  Element of menu - author informations
     */
    private JMenuItem menuAuthorInfo;
    
    /**
     *  Left-Top panel
     */
    private JPanel topLeftPanel;
    
    /**
     *  Left-Bottom panel
     */
    private JPanel botLeftPanel;
    
    /**
     *  Panel on right side
     */
    private JPanel rightPanel;
    
    /**
     *  Panel on left side
     */
    private JPanel leftPanel;
    
    /**
     *  Panel with encode.decode options
     */
    private JPanel encodePanel;
    
    /**
     *  Panel history
     */
    private JPanel historyLaber;
    
    /**
     *  Horizontally splited pane
     */
    private JSplitPane horPaneSplit;
    
    /**
     *  Vertically splited pane
     */
    private JSplitPane verPaneSplit;
    
    /**
     *  Encode button - true by default
     */
    private JRadioButton encodeButton;
    
    /**
     *  Decode button 
     */
    private JRadioButton decodeButton;

    /**
     *  Temp laber used to insert history
     */
    private JLabel myLaber;
    JPanel panel = new JPanel();
    /**
     * Metheod creates main window from definied elements
     * 
      @param title   program title
     */
    public View(String title) 
    {   
        // FRAME
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(675, 245);
        
        /*-------------------- MENU --------------------*/
        menuBar = new JMenuBar();
        menu = new JMenu("myMenu");
        menuBar.add(menu);

        menuVersion = new JMenuItem("Version");
        menu.add(menuVersion);
        menuAuthorInfo = new JMenuItem("Author");
        menu.add(menuAuthorInfo);
        
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        
        /*------------------- PANELS -------------------*/
        topLeftPanel = new JPanel();
        botLeftPanel = new JPanel();
        rightPanel   = new JPanel();      
      
        topLeftPanel.setLayout(new BoxLayout(topLeftPanel, BoxLayout.Y_AXIS));
        botLeftPanel.setLayout(new BoxLayout(botLeftPanel, BoxLayout.LINE_AXIS));
        botLeftPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        botLeftPanel.add(Box.createHorizontalGlue());
        /*------ GI_PANEL ------*/
        leftPanel = new JPanel();
        leftPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Insert data:", TitledBorder.LEFT, TitledBorder.TOP));
        GridLayout layout = new GridLayout(0,2);
        layout.setHgap(10);
        layout.setVgap(10);
        leftPanel.setLayout(layout);   
        
        inputLabel = new JLabel("Input file name:");
        inputTextfield = new JTextField();
        inputTextfield.setText("input.txt");
        
        outputLabel = new JLabel("Output file name:");
        outputTextfield = new JTextField();    
        outputTextfield.setText("output.txt");
        
        shiftLabel = new JLabel("Shift number");
        shiftTextfield = new JTextField();    
        shiftTextfield.setText("-3");
        
        leftPanel.add(inputLabel); 
        leftPanel.add(inputTextfield); 
        leftPanel.add(outputLabel); 
        leftPanel.add(outputTextfield);
        leftPanel.add(shiftLabel); 
        leftPanel.add(shiftTextfield);
        
        /*------ A_PANEL ------*/
        encodePanel = new JPanel();
        encodePanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(), "Select operation", TitledBorder.LEFT, TitledBorder.TOP));
        
        ButtonGroup myButtonGroup = new ButtonGroup();
        encodeButton = new JRadioButton("Encode", true);    
        decodeButton=new JRadioButton("Decode");      
        myButtonGroup.add(encodeButton); 
        myButtonGroup.add(decodeButton);        

        encodePanel.add(encodeButton);
        encodePanel.add(decodeButton);
        
        /*----- G_BUTTON -----*/
        runApp = new JButton("START");
        exit = new JButton("EXIT");

        topLeftPanel.add(leftPanel);
        botLeftPanel.add(encodePanel);
        botLeftPanel.add(runApp);
        botLeftPanel.add(exit);
        
        /*------------------- SPLIT -------------------*/
        horPaneSplit = new JSplitPane(SwingConstants.HORIZONTAL, topLeftPanel, botLeftPanel);
        horPaneSplit.setOrientation(SwingConstants.HORIZONTAL);
        
        verPaneSplit = new JSplitPane(SwingConstants.VERTICAL, horPaneSplit, rightPanel);
        verPaneSplit.setOrientation(SwingConstants.VERTICAL);
       
        frame.add(verPaneSplit);
        frame.setVisible(true);   
    }

    /**
     * Method fills history panel
     *
     * @param cnt int counter
     * @param str1 string input file name
     * @param str2 string output file name
     * @param cnt2 int shift
     */
    public void vHistory(int cnt, String str1, String str2, int cnt2){
        
        historyLaber = new JPanel();
        historyLaber.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "", TitledBorder.CENTER, TitledBorder.TOP));
        //myLaber = new JLabel(str);
        //historyLaber.add(myLaber);
        String[][] rec = {
           { String.valueOf(cnt), str1,str2,String.valueOf(cnt2)},
        };
        String[] header = { "Lp", "Input", "Output","Shift" };
        JTable table = new JTable(rec, header);
        historyLaber.add(table);
        //historyLaber.add(new JScrollPane(table));
        rightPanel.add(historyLaber);
        
        
        frame.setVisible(true);  
        rightPanel.setVisible(true);
    }

    

    /**
     * Getter for decode button status
     *
     * @return boolean status of decode button
     */
    public boolean getDecodeStatus(){
        return decodeButton.isSelected();
    }
    
    
    /**
     * Return data from text field
     * 
      @return inputTextfield input that will be saved
     */
    public JTextField getInputTextfield() {
     return inputTextfield;
    }

    /**
     * Return data from text field
     * 
      @return outputTextfield output that will be saved
     */
    public JTextField getOutputTextfield() {
     return outputTextfield;
    }
    
    /**
     * Return data from text field
     * 
      @return shiftTextfield shift that will be saved
     */
    public JTextField getShiftTextfield() {
     return shiftTextfield;
    }
    

    /**
     * When start button is pressed
     * 
      @return runApp start action
     */
    public JButton getStart() {
        //rightPanel.add(label);
     return runApp;
    }
    
    /**
     * Getter for info menu option
     *
     * @return sends info about selected option
     */
    public JMenuItem getInfo() {
        //rightPanel.add(label);
     return menuAuthorInfo;
    }
    
    /**
     * Getter for version menu option
     *
     * @return sends info about selected option
     */
    public JMenuItem getVersion() {
        //rightPanel.add(label);
     return menuVersion;
    }
    

    /**
     * When exit button is pressed
     * 
      @return exit exit action
     */
    public JButton getExit() {
     return exit;
    }

////////////////////////////////////////////////////////////////////////////////
   
        
    /**
     * Method reads data from given file to an array list.
     * 
     * @param lines - array list of text rows
     * @param input - input file name
     * @throws pl.polsl.stasica.krystian.model.FileNotFoundErrorException when file was not found
     * @throws java.io.IOException throws when program can't locate path to file
     */
    public void readToFile(ArrayList<String> lines, String input ) throws FileNotFoundErrorException,IOException{
        
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
     * @throws pl.polsl.stasica.krystian.model.FileNotFoundErrorException   when filename was not found
     * @throws java.io.IOException throws when program can't locate path to file
     */
    public void loadToFile(ArrayList<String> lines, String output) throws FileNotFoundErrorException,IOException{
        
        File tempFile = new File(output);


        try (FileWriter file = new FileWriter(output)) 
        {
            for(String str: lines)
                file.write(str + System.lineSeparator());
        }
        boolean exists = tempFile.exists();
        if(!exists)
            throw new FileNotFoundErrorException();
        
        System.out.println("Successfully wrote to the file.");
    } 
    
    /**
     * Method is printing in view, can be used in controller.
     * 
     * @param ex our exception that we want pass to method
     */
        public void displayException(Exception ex) 
        {
                MyInterface myInterface = (String text) -> {
                System.out.println(text);
            };

            myInterface.printIt(ex.getMessage());

        }
    
}
