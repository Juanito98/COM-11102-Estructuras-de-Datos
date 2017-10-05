/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package primerparcialesqueleto;

/**
 *
 * @author agomezdg
 * @param <T>
 */
public class ArrayStack<T> implements StackADT<T> {
    private final int DEFAULT_CAPACITY=100;
    private int top;
    private T[] stack;

    public ArrayStack() {
        top=0;
        stack=(T[])(new Object[DEFAULT_CAPACITY]);
    }

    public ArrayStack(int initialCapacity) {
        top=0;
        stack=(T[])(new Object[initialCapacity]);
    }

    public void push(T element) {
        if(top==stack.length)
            expandCapacity();
        stack[top]=element;
        top++;
    }

    private void expandCapacity() {
        T[] larger=(T[])(new Object[stack.length*2]);
        int index;

        for(index=0;index<stack.length;index++)
            larger[index]=stack[index];
        stack=larger;
    }

    public T pop() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("Stack underflow.");
        else {
            top--;
            T result=stack[top];
            stack[top]=null;

            return result;
        }
    }

    public T peek() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("Stack underflow.");
        else

           return stack[top-1];

    }

    public boolean isEmpty() {
        boolean result=false;

        if(top==0)
            result=true;

        return result;
    }
}
