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
public interface SetADT<T> extends Iterable<T> {
  /* Adds one element to this set, ignoring duplicates: */
  public void add (T element);

  /* Returns true if this set contains the parameter: */
  public boolean contains (T target);

  /* Returns true if this set contains no elements: */
  public boolean isEmpty();

  /* Returns the number of elements in this set: */
  public int size();

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
  public String toString();
}
