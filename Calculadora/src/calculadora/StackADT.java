/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author juani
 * @param <T>
 */
public interface StackADT <T> {
    public void push(T x);
    public T pop();
    public T peek();
    public boolean isEmpty();
}
