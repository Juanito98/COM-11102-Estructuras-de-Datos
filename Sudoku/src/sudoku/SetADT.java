/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

import java.util.*;

/**
 *
 * @author agomezdg
 * @param <T>
 */
public interface SetADT<T> extends Iterable<T> {
    /* Adds one element to this set, avoiding duplication: */
    public void add (T element);

    /* Returns true if this set contains the parameter: */
    public boolean contains (T target);

    /* Removes and returns a random element from this set: */
    public T removeRandom () throws Exception;

    /* Removes and returns the specified element from this set: */
    public T remove (T element) throws Exception;

    /* Returns true if this set contains no elements: */
    public boolean isEmpty();

    /* Returns the number of elements in this set: */
    public int size();

    /* Adds all the elements of the parameter to this set (merges
     * another set with this one): */
    public void addAll (SetADT<T> set);

    /* Returns true if this set and the parameter contain exactly
     * the same elements: */
    public boolean equals (SetADT<T> set);

    /* Non-destructive method that returns, in a new set, the union of this set and
  // the parameter: */
  public SetADT<T> union(SetADT<T> set);

  /* Non-destructive method that returns, in a new set, the intersection of this
  // set and the parameter: */
  public SetADT<T> intersection(SetADT<T> set);

  /* Non-destructive method that returns, in a new set, the difference of this
  // set and the parameter: */
  public SetADT<T> difference(SetADT<T> set);
    
    /* Returns an iterator over this set: */
    public Iterator<T> iterator();

    /* Prints the contents of this set: */
    @Override
    public String toString();
    
    
}
