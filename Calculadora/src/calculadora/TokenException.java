/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author JSIGLERP
 */
public class TokenException extends RuntimeException {
    public TokenException(String s) { super("Token Exception. " + s); }
    public TokenException() { this(""); }
}
