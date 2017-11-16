/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cesarmessage;

/**
 *
 * @author JSIGLERP
 */
public class EmptyCollectionException extends RuntimeException {

    public EmptyCollectionException(String st) {
        super("La colección está vacía. " + st);
    }
    public EmptyCollectionException() { this(""); }

    
}
