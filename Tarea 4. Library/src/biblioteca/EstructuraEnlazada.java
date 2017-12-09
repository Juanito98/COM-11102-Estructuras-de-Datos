/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author JSIGLERP
 */
public class EstructuraEnlazada <T> {
    private Nodo<T> primero;
    
    public EstructuraEnlazada(){
        primero = null;
    }
    
    public void agregaAlInicio(T dato){
        Nodo < T > nuevo = new Nodo(dato);
        nuevo.setSiguiente(primero);
        primero = nuevo;
    }
    
    public void agregaAlFinal(T dato){
        if(primero == null) 
            agregaAlInicio(dato);
        else {
            Nodo < T > it = primero;
            while(it.getSiguiente() != null)
                it = it.getSiguiente();
            Nodo < T > nuevo = new Nodo(dato);
            it.setSiguiente(nuevo);
        }
    }

    public void agregaDespuesDe(T datoViejo, T datoNuevo){
        Nodo < T > it = primero;
        while(it != null && !it.getDato().equals(datoNuevo))
            it = it.getSiguiente();
        if(it == null) 
            agregaAlFinal(datoNuevo);
        else {
            Nodo < T > nuevo = new Nodo(datoNuevo);
            nuevo.setSiguiente(it.getSiguiente());
            it.setSiguiente(nuevo);
        }
    } 
    
    public T eliminaPrimero() {
        //if(primero == null) 
            //throw new Exception("EmptyCollectionException");
        T ans = primero.getDato();
        primero = primero.getSiguiente();
        return ans;
    }
    
    public T eliminaUltimo() {
        //if(primero == null)
            //throw new Exception("EmptyCollectionException");
        Nodo < T > it = primero;
        while(it.getSiguiente() != null)
            it = it.getSiguiente();
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
            Nodo < T > it = primero;
            while(it.getSiguiente() != null && !it.getSiguiente().getDato().equals(dato))
                it = it.getSiguiente();
            if(it.getSiguiente() == null)
                return null;
            else {
                it.setSiguiente(it.getSiguiente().getSiguiente());
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
        Nodo < T > it = primero;
        while(it.getSiguiente() != null)
            it = it.getSiguiente();
        return it.getDato();
    }
    
    public int size() {
        Nodo < T > it = primero;
        int cnt = 0;
        while(it != null) {
            it = it.getSiguiente();
            cnt++;
        }
        return cnt;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }
        
    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("EstructuraEnlazada{\n");
        Nodo < T > it = primero;
        while(it != null) {
            st.append("\t").append(it.getDato().toString()).append('\n');
            it = it.getSiguiente();
        }
        st.append("}");
        return st.toString();
    }
    
}

