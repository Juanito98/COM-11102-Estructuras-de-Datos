/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author juani
 */
public class DoublyLinkedOrderedList < T extends Comparable < T > > extends DoublyLinkedList < T > implements OrderedListADT < T > {

    @Override
    public void add(T dato) {
        NodoDoble < T > it = this.lista.getUltimo();
        while(it != null && it.getDato().compareTo(dato) > 0)
            it = it.getAnterior();
        if(it == null)
            lista.agregaAlInicio(dato);
        else
            lista.agregaDespuesDe(it.getDato(), dato);
    }
    
    
}
