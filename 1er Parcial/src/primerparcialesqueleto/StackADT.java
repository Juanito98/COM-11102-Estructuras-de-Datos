/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package primerparcialesqueleto;

/**
 *
 * @author agomezdg
 */
public interface StackADT<X> {
    public void push(X objeto);

    public X peek();

    public X pop();

    public boolean isEmpty();
}

