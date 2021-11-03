/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.stasica.krystian.model;

import java.io.IOException;

/**
 * Exception class for objects thrown when given file was not found.
 *
 * @author Krystian Stasica
 * @version 0.2
 */
public class FileNotFoundErrorException extends IOException {

    /**
     * Non-parameter constructor
     */
    public FileNotFoundErrorException() 
    {
        super("Program was not able to find file.\n"
        + "Please check file path.");
    }
    
    /**
     * Exception class constructor
     *
     * @param errorMessage  message of our error
     */
    public FileNotFoundErrorException(String errorMessage) 
    {
        super(errorMessage);
    }
}

