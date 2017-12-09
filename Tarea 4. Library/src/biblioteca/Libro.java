/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Objects;

/**
 *
 * @author JSIGLERP
 */
public class Libro implements Comparable < Libro > {
    private String autor, titulo, editorial;
    private Integer year;
    private ClaveDeCatalogo clave;

    public Libro(String autor, String titulo, String editorial, Integer year, ClaveDeCatalogo clave) {
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.year = year;
        this.clave = clave;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getYear() {
        return year;
    }

    public ClaveDeCatalogo getClave() {
        return clave;
    }

    @Override
    public String toString() {
        return "Libro{" + "autor=" + autor + ", titulo=" + titulo + ", editorial=" + editorial + ", year=" + year + ", clave=" + clave + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }

    

    @Override
    public int compareTo(Libro o) {
        return this.clave.compareTo(o.clave);
    }
    
    
    
}
