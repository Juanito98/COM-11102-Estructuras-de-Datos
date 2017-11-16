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
public interface QueueADT <T> {
    public void enqueue(T dato);
    public T dequeue();
    public T first();
    public boolean isEmpty();
}
