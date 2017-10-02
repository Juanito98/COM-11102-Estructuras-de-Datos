/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot;

/**
 *
 * @author juani
 */
public class MismatchException extends RuntimeException {
    public MismatchException(String s) { super("Error de emparejamiento. " + s); }
    public MismatchException() { this(""); }
}
