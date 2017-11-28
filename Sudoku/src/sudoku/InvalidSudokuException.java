/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author juani
 */
public class InvalidSudokuException extends Exception {
    private final int i, j;
    
    public InvalidSudokuException(Integer i, Integer j, String s) {
        super("La casilla (" + i.toString() + " , " + j.toString() + ") es inválida. " + s);
        this.i = i;
        this.j = j;
    }
    
    public InvalidSudokuException(Integer i, Integer j) {
        this(i, j, "");
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    
    
}
