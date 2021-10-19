/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pl.polsl.stasica.krystian.test;

import pl.polsl.stasica.krystian.test2.PrintingClass;


/**
 *
 * @author dv6
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrintingClass myPrintingClassObj = new PrintingClass();
        myPrintingClassObj.print();
    try
    {
        Thread.sleep(3000);
    }
    catch(InterruptedException ex)
    {
        Thread.currentThread().interrupt();
    }
    }
    
}
