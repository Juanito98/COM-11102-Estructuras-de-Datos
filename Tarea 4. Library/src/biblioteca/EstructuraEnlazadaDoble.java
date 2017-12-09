/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author juani
 * @param <T>
 */
public class EstructuraEnlazadaDoble < T > {
    private NodoDoble <T> primero, ultimo;
    
    public EstructuraEnlazadaDoble(){
        primero = null;
        ultimo = null;
    }
    
    public void agregaAlInicio(T dato){
        NodoDoble < T > nuevo = new NodoDoble(dato);
        nuevo.setSiguiente(primero);
        if(primero != null)
            primero.setAnterior(nuevo);        
        primero = nuevo;
        if(ultimo == null)
            ultimo = primero;
    }
    
    public void agregaAlFinal(T dato){
        if(primero == null) 
            agregaAlInicio(dato);
        else {
            NodoDoble < T > nuevo = new NodoDoble(dato);
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        
    }

    public void agregaDespuesDe(T datoViejo, T datoNuevo){
        NodoDoble < T > it = primero;
        while(it != null && !it.getDato().equals(datoNuevo))
            it = it.getSiguiente();
        if(it == null) 
            agregaAlFinal(datoNuevo);
        else {
            NodoDoble < T > nuevo = new NodoDoble(datoNuevo);
            nuevo.setSiguiente(it.getSiguiente());
            if(nuevo.getSiguiente() != null)
                nuevo.getSiguiente().setAnterior(nuevo);
            nuevo.setAnterior(it);
            it.setSiguiente(nuevo);
            it.setSiguiente(nuevo);
        }
    } 
    
    public T eliminaPrimero() {
        //if(primero == null) 
            //throw new Exception("EmptyCollectionException");
        T ans = primero.getDato();
        primero = primero.getSiguiente();
        primero.setAnterior(null);
        return ans;
    }
    
    public T eliminaUltimo() {
        //if(primero == null)
            //throw new Exception("EmptyCollectionException");
        NodoDoble < T > it = primero;
        while(it.getSiguiente() != null)
            it = it.getSiguiente();
        if(it.getAnterior() != null)
            it.getAnterior().setSiguiente(null);
        T ans = it.getDato();
        it = null;
        return ans;
    }
    
    
    public T eliminaDato(T dato) {
        if(primero == null)
            return null;
        else if(primero.getDato().equals(dato))
            return eliminaPrimero();
        else {
            NodoDoble < T > it = primero;
            while(it != null && !it.getDato().equals(dato))
                it = it.getSiguiente();
            if(it == null)
                return null;
            else {
                if(it.getAnterior() != null)
                    it.getAnterior().setSiguiente(it.getSiguiente());
                if(it.getSiguiente() != null)
                    it.getSiguiente().setAnterior(it.getAnterior());
                return dato;
            }
        }
    }
    
    public boolean isEmpty() {
        return primero == null;
    }
    
    public T first() {
        return primero.getDato();
    }
    
    public T last() {
        return ultimo.getDato();
    }
    
    public int size() {
        NodoDoble < T > it = primero;
        int cnt = 0;
        while(it != null) {
            it = it.getSiguiente();
            cnt++;
        }
        return cnt;
    }

    public NodoDoble<T> getPrimero() {
        return primero;
    }
    
    public NodoDoble<T> getUltimo() {
        return ultimo;
    }
        
    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("EstructuraEnlazada{\n");
        NodoDoble < T > it = primero;
        while(it != null) {
            st.append("\t").append(it.getDato().toString()).append('\n');
            it = it.getSiguiente();
        }
        st.append("}");
        return st.toString();
    }
    
}
