/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;
import java.util.*;

/**
 *
 * @author JSIGLERP
 * @param <T>
 */
public class LinkedOrderedList < T extends Comparable < T > > extends LinkedList < T > implements OrderedListADT < T > {
    
    @Override
    public void add(T dato) {
        Iterator < T > it = this.iterator();
        T datoViejo = null;
        while(it.hasNext()) {
            T datoActual = it.next();
            if(dato.compareTo(datoActual) > 0)
                datoViejo = datoActual;
        }
        if(datoViejo == null)
            lista.agregaAlInicio(dato);
        else
            lista.agregaDespuesDe(datoViejo, dato);
    }
    
}
