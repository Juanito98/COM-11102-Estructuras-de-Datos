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
    
    private static int f(int i, int j) {
        return i/sqrt_n * sqrt_n + j/sqrt_n;
    }
    
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
    
    private static boolean solve_sudoku(int i, int j) throws TimeoutException {
        if(System.currentTimeMillis() - INITIAL_TIME > 10000)
            throw new TimeoutException("Tiempo límite excedido. Posiblemente no tenga solución el sudoku");
        else if(i >= n)
            return true;            
        else if(sudo[i][j] != 0) 
            return solve_sudoku(i, j + 1);
        else {
            for(int x = 1; x <= n; x++) {
                if(!insert(i, j, x)) continue;
                if(solve_sudoku(j+1 < n ? i : i+1, j+1 < n ? j+1 : 0)) return true;
                erase(i, j);
            }
            return false;
        }
    }
    
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


/*
Sample Cases:

5 3 0 0 7 0 0 0 0
6 0 0 1 9 5 0 0 0
0 9 8 0 0 0 0 6 0
8 0 0 0 6 0 0 0 3
4 0 0 8 0 3 0 0 1
7 0 0 0 2 0 0 0 6
0 6 0 0 0 0 2 8 0
0 0 0 4 1 9 0 0 5
0 0 0 0 8 0 0 7 9

//The next one is impossible
3 0 0 0 0 0 0 0 4
0 0 2 0 6 0 1 0 0
0 1 0 9 0 8 0 2 0
0 0 5 0 0 0 6 0 0
0 2 0 0 0 0 0 1 0
0 0 9 0 0 0 8 0 0
0 8 0 3 0 4 0 6 0
0 0 4 0 1 0 9 0 0
5 0 0 0 0 0 0 0 7

*/
