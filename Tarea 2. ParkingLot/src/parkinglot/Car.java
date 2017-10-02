/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot;

/**
 *
 * @author juani
 */
public class Car {
    private int id;
    private String owner, plates;
    public Car(String o, int id, String p) throws MismatchException {
        if(o.equals("")) 
            throw new MismatchException("Falta nombre."); 
        if(id < 100000 || id > 999999) 
            throw new MismatchException("Clave inválida."); 
        if(p.length() != 6) 
            throw new MismatchException("Las placas deben contener 6 caracteres.");
        for(int i = 1; i <= 2; i++) {
            if(p.charAt(i) < '0' || p.charAt(i) > '9') 
                throw new MismatchException("El " + (i + 1) + "° caracter de las placas debe ser un dígito.");
        } 
        for(int i = 0; i < 6; i++) {
            if(i == 1 || i == 2) continue;
            if(p.charAt(i) == 'O' || p.charAt(i) == 'I')
                throw new MismatchException("El " + (i + 1) + "° caracter de las placas NO debe ser I/O.");
            if(p.charAt(i) < 'A' || p.charAt(i) > 'Z') 
                throw new MismatchException("El " + (i + 1) + "° caracter de las placas debe ser una letra Mayúscula.");
        }
        this.id = id;
        this.owner = o;
        this.plates = p;
    }
    public Car() {}
    
    public String getOwner() { return this.owner; }
    
    @Override
    public String toString() {
        return "Dueño: " + this.owner + "\nClave: " + this.id + "\nPlacas: " + this.plates; 
    }
}
