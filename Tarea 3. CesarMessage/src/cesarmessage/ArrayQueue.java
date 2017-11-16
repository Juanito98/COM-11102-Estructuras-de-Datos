package cesarmessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JSIGLERP
 * @param <T>
 */
public class ArrayQueue <T> implements QueueADT <T> {
    private final int DEFAULT_CAPACITY = 1;
    private T[] arr;
    private int ini, fin;
    
    public ArrayQueue() {
        arr = (T[])(new Object[DEFAULT_CAPACITY]);
        ini = fin = 0;
    }
    
    private void expandCapacity() {
        T[] nuevo = (T[])(new Object[arr.length * 2]);
        for(int i = 0; i < arr.length; i++)
            nuevo[i] = arr[(ini + i) % arr.length];
        ini = 0;
        fin = arr.length;
        arr = nuevo;
    }
    
    @Override
    public void enqueue(T dato) {
        if(isFull()) 
            expandCapacity();
        arr[fin] = dato;
        fin = (fin + 1) % arr.length;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()) 
            throw new EmptyCollectionException("Queue.");
        T x = arr[ini];
        arr[ini] = null;
        ini = (ini + 1) % arr.length;
        return x;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if(isEmpty()) 
            throw new EmptyCollectionException("Queue.");
        return arr[ini];
    }

    @Override
    public boolean isEmpty() {
        return ini == fin && arr[ini] == null;
    }
    
    private boolean isFull() {
        return ini == fin && arr[ini] != null;
    }
    
}
