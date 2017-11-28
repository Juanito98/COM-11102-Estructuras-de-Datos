/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

/**
 *
 * @author agomezdg
 */
public class EmptyCollectionException extends Exception{
    public EmptyCollectionException() {
        super("The collection is empty.");
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
