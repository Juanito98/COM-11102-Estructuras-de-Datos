/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot;

/**
 *
 * @author juani
 * @param <T>
 */
public class ArrayStackLimitada <T> extends ArrayStack <T> {
    private final int MAX_CAPACITY;
    private int cnt;
    public ArrayStackLimitada(int size) { 
        super(size);
        this.MAX_CAPACITY = size;
        this.cnt = 0;
    }
    
    public boolean isFull() { return cnt >= MAX_CAPACITY; }
    
    @Override
    public T pop() throws EmptyCollectionException {
        if(isEmpty()) throw new EmptyCollectionException("Pila vacía.");
        cnt--;
        return super.pop();
    }
    
    @Override
    public void push(T x) throws FullCollectionException {
        if(isFull()) throw new FullCollectionException("Pila llena.");
        super.push(x);
        cnt++;
    }
    
    public int size() { return this.MAX_CAPACITY; }
}
