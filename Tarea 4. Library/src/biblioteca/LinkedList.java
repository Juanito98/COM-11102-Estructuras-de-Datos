/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Iterator;

/**
 *
 * @author JSIGLERP
 */
public class LinkedList < T > implements ListADT < T > {
    EstructuraEnlazada < T > lista;

    public LinkedList() {
        this.lista = new EstructuraEnlazada<>();
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

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(lista.getPrimero());
    }
    
    public String toString() {
        return lista.toString();
    }
    
}
