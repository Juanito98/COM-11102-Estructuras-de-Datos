/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundoparcialparteprogramadaesqueletogpo1;

/**
 *
 * @author ZVIX0
 */
public class Main2 {
    
    public static double pi(int k) {
        if(k < 0) 
            return 0;
        else
            return (k%2 == 0 ? 4.0 : -4.0) / (2 * k + 1) + pi(k - 1);
    }
    
    public static void main(String chwl[]) {
        // Debería imprimir 4:
        System.out.println("Pi con una expansión de un término: "+pi(0));
        
        // Debería imprimir 2.6666...:
        System.out.println("Pi con una expansión de dos términos: "+pi(1));
        
        // Debería imprimir 3.1892...:
        System.out.println("Pi con una expansión de 21 términos: "+pi(20));
    }
    
    // Aquí hay que insertar la definición del método "pi" (y cualquier otro
    // método de apoyo que sea necesario)...
}