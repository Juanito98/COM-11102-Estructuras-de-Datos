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
public class ClaveDeCatalogo implements Comparable <ClaveDeCatalogo>{
    private Double numero;
    private String cadena;

    public ClaveDeCatalogo(Double numero, String cadena) {
        this.numero = numero;
        this.cadena = cadena;
    }

    @Override
    public int compareTo(ClaveDeCatalogo o) {
        return this.numero.equals(o.getNumero()) == true ? this.cadena.compareTo(o.getCadena()) : this.numero.compareTo(o.getNumero());
    }

    public double getNumero() {
        return numero;
    }

    public String getCadena() {
        return cadena;
    }

    @Override
    public String toString() {
        return "ClaveDeCatalogo{" + "numero=" + numero + ", cadena=" + cadena + '}';
    }
    
    
    
}
