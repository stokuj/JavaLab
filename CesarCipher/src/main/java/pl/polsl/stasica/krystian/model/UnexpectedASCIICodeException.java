/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.stasica.krystian.model;

/**
 *
 * @author dv6
 */
public class UnexpectedASCIICodeException extends Exception{
    
    public UnexpectedASCIICodeException() 
    {
        super("Unexped character was found");
    }
    
    public UnexpectedASCIICodeException(char c, int x) 
    {   
        super("Unexped character was found: "+ c +" ASCII Code: "+ x);
    }
}
