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
public class ArraySet<T> implements SetADT<T> {
    private static final int DEFAULT_CAPACITY=100;
    private static Random rand=new Random();
    private static final int NOT_FOUND=-1;
    private int count;  // the current number of elements in the set
    private T[] contents;

    public ArraySet(int initialCapacity) {
        count=0;
        contents=(T[])(new Object[initialCapacity]);
    }

    public ArraySet() {
        this(DEFAULT_CAPACITY);
    }

    public void add(T element) {
        if(!(contains(element))) {
            if(size()==contents.length)
                expandCapacity();
            contents[count]=element;
            count++;
        }
    }

    private void expandCapacity() {
        T[] larger=(T[])(new Object[contents.length*2]);
        for(int index=0;index<contents.length;index++)
            larger[index]=contents[index];
        contents=larger;
    }

    public boolean contains(T target) {
        return searchTarget(target)!=NOT_FOUND;
    }

    private int searchTarget(T target) {
        int search=NOT_FOUND;
        int index=0;
        while(index<count&&search==NOT_FOUND) {
            if(contents[index].equals(target))
                search=index;
            index++;
        }
        return search;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public int size() {
        return count;
    }

    public Iterator<T> iterator() {
        return new ArrayIterator<T>(contents, count);
    }

    public String toString() {
    	StringBuilder result=new StringBuilder();
    	for(int index=0;index<count;index++)
            result.append(contents[index].toString()+"\n");
    	return result.toString();
    }
    
    @Override
    public SetADT < T > union(SetADT < T > set) {
        SetADT < T > ans = new ArraySet();
        Iterator < T > it = this.iterator();
        while(it.hasNext()) 
            ans.add(it.next());
        it = set.iterator();
        while(it.hasNext()) 
            ans.add(it.next());
        return ans;
    }
    
    @Override
    public SetADT < T > intersection(SetADT < T > set) {
        SetADT < T > ans = new ArraySet();
        Iterator < T > it = this.iterator();
        while(it.hasNext()) {
            T aux = it.next();
            if(set.contains(aux)) 
                ans.add(aux);
        }
        return ans;
    }
    
    @Override
    public SetADT < T > difference(SetADT < T > set) {
        SetADT < T > ans = new ArraySet();
        Iterator < T > it = this.iterator();
        while(it.hasNext()) {
            T aux = it.next();
            if(!set.contains(aux)) 
                ans.add(aux);
        }
        return ans;
    }
}
