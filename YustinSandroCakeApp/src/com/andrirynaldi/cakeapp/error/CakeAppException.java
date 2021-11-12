/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.andrirynaldi.cakeapp.error;

/**
 *
 * @author andri
 */
public class CakeAppException extends Exception{

    /**
     * Creates a new instance of <code>CakeAppException</code> without detail
     * message.
     */
    public CakeAppException() {
    }

    /**
     * Constructs an instance of <code>CakeAppException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CakeAppException(String msg) {
        super(msg);
    }
}
