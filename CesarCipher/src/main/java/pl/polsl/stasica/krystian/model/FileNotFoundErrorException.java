/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.stasica.krystian.model;

import java.io.IOException;
/**
 *
 * @author dv6
 */
public class FileNotFoundErrorException extends IOException {
    
    public FileNotFoundErrorException() 
    {
        super("Program was not able to find file.\n"
        + "Please check file path.");
    }
}

