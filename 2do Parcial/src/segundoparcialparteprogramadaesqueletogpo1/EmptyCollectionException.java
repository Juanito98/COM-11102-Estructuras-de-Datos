/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcialparteprogramadaesqueletogpo1;

/**
 *
 * @author AGOMEZDG
 */
public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException(){
        super("The collection is empty.");
    }

    public EmptyCollectionException(String message){
        super("The collection is empty: "+message);
    }
}
