/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package segundoparcialparteprogramadaesqueletogpo1;

import java.util.*;

/**
 *
 * @author agomezdg
 */
public class ArrayIterator<T> implements Iterator<T> {
    private int count;    // the number of elements in the collection
    private int current;  // the current position in the iteration
    private T[] items;

    public ArrayIterator(T[] collection,int size) {
        items=collection;
        count=size;
        current=0;
    }

    public boolean hasNext() {
        return current<count;
    }

    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        else {
            current++;
            return items[current-1];
        }
  }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
