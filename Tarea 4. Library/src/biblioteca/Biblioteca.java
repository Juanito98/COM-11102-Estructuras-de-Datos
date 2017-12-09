/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author JSIGLERP
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 5;
        Libro[] arr = {
            new Libro("juan1", "Libro1", "ED1", 2017, new ClaveDeCatalogo(36.5, "HJQ")),
            new Libro("juan2", "Libro2", "ED2", 2017, new ClaveDeCatalogo(78.5, "HJQ")),
            new Libro("juan3", "Libro3", "ED3", 2017, new ClaveDeCatalogo(34.22, "LEK")),
            new Libro("juan4", "Libro4", "ED4", 2017, new ClaveDeCatalogo(34.22, "LAK")),
            new Libro("juan5", "Libro5", "ED5", 2017, new ClaveDeCatalogo(209.71, "ABC"))
        };
        
        LinkedOrderedList < Libro > lista = new LinkedOrderedList<>();
        for(int i = 0; i < n; i++)
            lista.add(arr[i]);
        System.out.println(lista);
        lista.remove(arr[0]); // {36.5, HJQ}
        System.out.println("Eliminado.\n" + lista);
        
        DoublyLinkedOrderedList < Libro > listaDoble = new DoublyLinkedOrderedList<>();
        for(int i = 0; i < n; i++)
            listaDoble.add(arr[i]);
        System.out.println(listaDoble);
        listaDoble.remove(arr[0]); // {36.5, HJQ}
        System.out.println("Eliminado.\n" + listaDoble);
        
    }
    
}
