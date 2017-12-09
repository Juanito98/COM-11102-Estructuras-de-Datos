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
public class DoublyLinkedList < T > implements ListADT < T > {
    EstructuraEnlazadaDoble < T > lista;

    public DoublyLinkedList() {
        this.lista = new EstructuraEnlazadaDoble<>();
    }
    
    @Override
    public T removeFirst() {
        return lista.eliminaPrimero();
    }

    @Override
    public T removeLast() {
        return lista.eliminaUltimo();
    }

    @Override
    public T remove(T dato) {
        return lista.eliminaDato(dato);
    }

    @Override
    public T first() {
        return lista.first();
    }

    @Override
    public T last() {
        return lista.last();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public int size() {
        return lista.size();
    }
    
    public String toString() {
        return lista.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
