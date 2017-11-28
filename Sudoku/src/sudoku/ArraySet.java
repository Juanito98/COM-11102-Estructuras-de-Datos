/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

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

    public T removeRandom() {
        if(isEmpty())
            throw new EmptyCollectionException();
        else {
            int choice=rand.nextInt(count);
            T result=contents[choice];
            contents[choice]=contents[count-1];  // fill the gap
            contents[count-1]=null;
            count--;
            return result;
        }
    }

    public T remove(T target) {
        if(isEmpty())
            throw new EmptyCollectionException();
        else {
            int search=searchTarget(target);
            if(search==NOT_FOUND)
                throw new NoSuchElementException();
            else {
                T result=contents[search];
                contents[search]=contents[count-1];
                contents[count-1]=null;
                count--;
                return result;
            }
        }
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public int size() {
        return count;
    }

    public void addAll(SetADT<T> set) {
        for(T element:set)
            add(element);
    }
    
    @Override
    public boolean equals(SetADT<T> set) {
        boolean result = false;
        Iterator<T> it=set.iterator();

        if(size()==set.size()) {
            while(it.hasNext()&&contains(it.next()));
            if(!it.hasNext())
                result=true;
        }
        return result;
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
    
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(contents, count);
    }

    public String toString() {
    	StringBuilder result=new StringBuilder();
    	for(int index=0;index<count;index++)
            result.append(contents[index].toString()+"\n");
    	return result.toString();
    }
}
