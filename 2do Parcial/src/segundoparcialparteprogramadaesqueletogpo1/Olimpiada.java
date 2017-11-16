/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package segundoparcialparteprogramadaesqueletogpo1;

/**
 *
 * @author agomezdg
 */
public class Olimpiada {
    private String nombreCiudad;
    private int anio;

    Olimpiada(String nom,int a){
        nombreCiudad=nom;
        anio=a;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder("");

        sb.append(nombreCiudad+" "+anio);

        return sb.toString();
    }
}
