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
public interface ListADT < T > extends Iterable < T > {
    public T removeFirst();
    public T removeLast();
    public T remove(T dato);
    public T first();
    public T last();
    public boolean isEmpty();
    public int size();
    @Override
    public Iterator < T > iterator();
    @Override
    public String toString();
}
