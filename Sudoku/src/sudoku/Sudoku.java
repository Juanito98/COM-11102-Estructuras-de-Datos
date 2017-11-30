package sudoku;

import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sudoku {
    
    private static long INITIAL_TIME;
    private static final int n = 9, sqrt_n = 3;
    private static int[][] sudo;
    private static SetADT < Integer > row[] = new SetADT[n];
    private static SetADT < Integer > column[] = new SetADT[n];
    private static SetADT < Integer > subgrid[] = new SetADT[n];
    
    // Regresa el número del cuadrante de la casilla i,j [0, 9)
    private static int f(int i, int j) {
        return i/sqrt_n * sqrt_n + j/sqrt_n;
    }
    
    // Borra el elemento insertado en la casilla i, j
    private static void erase(int i, int j) {
        try {
            int x = sudo[i][j];
            row[i].remove(x);
            column[j].remove(x);
            subgrid[f(i, j)].remove(x);
            sudo[i][j] = 0;
        } catch (Exception ex) {
            Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Inserta x en la casilla i,j
    private static boolean insert(int i, int j, int x) {
        if(x < 1 || x > n) 
            return false;
        if(row[i].contains(x) || column[j].contains(x) || subgrid[f(i, j)].contains(x))
            return false;
        row[i].add(x);
        column[j].add(x);
        subgrid[f(i, j)].add(x);
        sudo[i][j] = x;
        return true;
    }
    
    // Búsqueda exhaustiva para solucionar el sudoku
    private static boolean solve_sudoku(int i, int j) throws TimeoutException {
        if(System.currentTimeMillis() - INITIAL_TIME > 10000)
            throw new TimeoutException("Tiempo límite excedido. Posiblemente no tenga solución el sudoku");
        else if(i >= n)
            return true;            
        else if(sudo[i][j] != 0) 
            return solve_sudoku(j+1 < n ? i : i+1, j+1 < n ? j+1 : 0);
        else {
            for(int x = 1; x <= n; x++) {
                if(!insert(i, j, x)) continue;
                if(solve_sudoku(j+1 < n ? i : i+1, j+1 < n ? j+1 : 0)) return true;
                erase(i, j);
            }
            return false;
        }
    }
    
    // Recibe el sudoku y regresa la solución a este
    public static int[][] solve(int matriz[][]) throws Exception {
        INITIAL_TIME = System.currentTimeMillis();
        sudo = new int[n][n];        
        for(int i = 0; i < n; i++) {
            row[i] = new ArraySet<>();
            column[i] = new ArraySet<>();
            subgrid[i] = new ArraySet<>();
        }
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                int x = matriz[i][j];
                if(x != 0) {
                    if(!insert(i, j, x)) 
                        throw new InvalidSudokuException(i, j, "El dígito " + x + " ya no puede ser usado.");
                }
                sudo[i][j] = x;
            }
        
        if(solve_sudoku(0, 0))
            return sudo;
        else 
            throw new Exception("No se encontró solución al sudoku.");
    }
    
}