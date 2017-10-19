/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

public class Solver {
    
    private static ArrayStack < Double > numbers;
    private static ArrayStack < Character > tokens;

    private static double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
    
    private static void execute(char c) throws RuntimeException {
        double a, b;
        try {
            b = numbers.peek();
            numbers.pop();
            a = numbers.peek();
            numbers.pop();
        } catch(Exception e) {
            throw new TokenException("El número de operandos no coincide con el número esperado de operadores.");
        }
        switch (c) {
            case '+' : 
                numbers.push(a + b); 
                break;
            case '-' : 
                numbers.push(a - b); 
                break;
            case '*' : case 'x': 
                numbers.push(a * b); 
                break;
            case '/' : 
                if(b == 0) 
                    throw new RuntimeException("Math Error. División por 0.");
                numbers.push(a / b); 
                break;
            case '^' : 
                numbers.push(Math.pow(a, b)); 
                break;
            default : 
                numbers.push(a);
                numbers.push(b);
        }
    }
    
    private static int value(char c) {
        switch (c) {
            case '+' : case '-' :
                return 1;
            case '*' : case 'x': case '/' : 
                return 2;
            case '^' : 
                return 3;
            case '(' : case ')' : 
                return 0;
            default : 
                return -1;
        }
    }
    
    private static void insert (char c) throws RuntimeException {
        if(value(c) == -1) 
            throw new TokenException("Unexpected Token. ");
        try {
            switch (c) {
                case '(':
                    tokens.push(c);
                    break;
                case ')':
                    while(tokens.peek() != '(') {
                        execute(tokens.peek());
                        tokens.pop();
                    }   tokens.pop();
                    break;
                default:
                    while(!tokens.isEmpty() && value(tokens.peek()) >= value(c)) {
                        execute(tokens.peek());
                        tokens.pop();
                    }   tokens.push(c);
                    break;
            }
        } catch(RuntimeException e) {
            if(e.getMessage().equals("Math Error. División por 0."))
                throw e;
            else 
                throw new TokenException("El número de operandos no coincide con el número esperado de operadores.");
        }
    }
    
    public static double solve (String st) throws Exception {
        //Inicializamos variables
        numbers = new ArrayStack<>(st.length());
        tokens = new ArrayStack<>(st.length());
        double num = 0, pot = 1;
        int signo = 1;
        boolean newNumber = false;
        for(int i = 0; i < st.length(); i++) {
            char c = st.charAt(i); 
            if(c == ' ' || c == '\n' || c == '\r') continue;
            if(c >= '0' && c <= '9') {
                newNumber = true;
                if(pot >= 1) {
                    num *= 10;
                    num += (c - '0') * signo;
                } else {
                    num += (c - '0') * pot * signo;
                    pot /= 10;
                }
            } else if(c == '.') {
                newNumber = true;
                pot = 0.1;
            } else if(c == '─'){
                signo *= -1;
            } else {
                if(newNumber) numbers.push(num);
                newNumber = false;
                signo = 1;
                pot = 1;
                num = 0;
                try {
                    insert(c);
                } catch(RuntimeException e) {
                    throw e;
                }
            }
        }
        if(newNumber) numbers.push(num);
        while(!tokens.isEmpty()) {
            try {
                execute(tokens.peek());
            } catch(TokenException e) {
                throw e;
            }
            tokens.pop();
        }
        num = numbers.pop();
        if(!numbers.isEmpty()) 
            throw new TokenException("El número de operandos no coincide con el número esperado de operadores.");
        return round(num, 4);
    }
}
