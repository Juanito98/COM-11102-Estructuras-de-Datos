/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author juani
 */
public class ArrayStack <T> implements StackADT <T> {
    private T[] stack;
    private int top;
    
    public ArrayStack(int s) {
        top = 0;
        stack = (T[])(new Object[s]);
    }
    public ArrayStack() { this(100); }
    private void expandCapacity() {
        T[] nuevo = (T[])(new Object[stack.length * 2]);
        for(int i = 0; i < stack.length; i++) 
            nuevo[i] = stack[i];
        stack = nuevo;
    }
    
    @Override
    public void push(T x) {
        if(top >= stack.length) expandCapacity();
        stack[top++] = x;
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyCollectionException("Pila vacía");
        top--;
        T x = stack[top];
        stack[top] = null;
        return x;
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new EmptyCollectionException("Pila vacía");
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() { return top <= 0; }
    
}
