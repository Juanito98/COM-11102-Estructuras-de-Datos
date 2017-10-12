/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;
import java.util.*;

public class Solver {
    
    private static Stack < Double > numbers;
    private static Stack < Character > tokens;

    private static void execute(char c) {
        double b = numbers.peek();
        numbers.pop();
        double a = numbers.peek();
        numbers.pop();
        switch (c) {
            case '+' : numbers.push(a + b); break;
            case '-' : numbers.push(a - b); break;
            case 'x' : numbers.push(a * b); break;
            case '/' : numbers.push(a / b); break;
            case '^' : numbers.push(Math.pow(a, b)); break;
            default : System.out.println("Unexpected token : " + c);
        }
    }
    
    private static int value(char c) {
        switch (c) {
            case '+' : case '-' : return 1;
            case '*' : case '/' : return 2;
            case '^' : return 3;
            default : return -1;
        }
    }
    
    private static void insert(char c) {
        if(c == '(') tokens.push(c);
        else if(c == ')') {
            while(tokens.peek() != '(') {
                execute(tokens.peek());
                tokens.pop();
            }
            tokens.pop();
        } else {
            while(!tokens.empty() && value(tokens.peek()) >= value(c)) {
                execute(tokens.peek());
                tokens.pop();
            }
            tokens.push(c);
        }
    }
    
    public static double solve(String st) {
        numbers = new Stack<>();
        tokens = new Stack<>();
        double num = 0, pot = 1;
        boolean newNumber = false;
        for(int i = 0; i < st.length(); i++) {
            char c = st.charAt(i); 
            if(c == ' ' || c == '\n') continue;
            if(c >= '0' && c <= '9') {
                newNumber = true;
                if(pot >= 1) {
                    num *= 10;
                    num += c - '0';
                } else {
                    num += (c - '0') * pot;
                    pot /= 10;
                }
            } else if(c == '.') {
                newNumber = true;
                pot = 0.1;
            } else {
                if(newNumber) numbers.push(num);
                newNumber = false;
                pot = 1;
                num = 0;
                insert(c);
            }
        }
        if(newNumber) numbers.push(num);
        while(!tokens.empty()) {
            execute(tokens.peek());
            tokens.pop();
        }
        return numbers.peek();
    }
}
