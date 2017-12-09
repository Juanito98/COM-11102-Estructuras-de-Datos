/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.*;

/**
 *
 * @author juani
 */
public class ListIterator < T > implements Iterator < T > {
    private Nodo < T > it;
    
    public ListIterator(Nodo < T > primero) {
        it = primero;
    }
    
    @Override
    public boolean hasNext() {
        return it != null;
    }

    @Override
    public T next() {
        T dato = it.getDato();
        it = it.getSiguiente();
        return dato;
    }
    
}
