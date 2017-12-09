/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author JSIGLERP
 * @param <T>
 */
public interface OrderedListADT < T extends Comparable < T > > extends ListADT < T > {
    public void add(T dato);
}
