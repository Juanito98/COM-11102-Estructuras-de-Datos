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
public class FullCollectionException extends RuntimeException {
    public FullCollectionException(String s) { super("La colección está llena. " + s); }
    public FullCollectionException() { this(""); }
}
