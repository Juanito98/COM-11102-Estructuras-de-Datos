/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package primerparcialesqueleto;

/**
 *
 * @author Juan Carlos Sigler Priego
 */
public class Programa1 {
    public static void main(String s[]) {
        /* Sí debería ser reconocido como palíndromo: */
	String frase="Anita lava la tina";
        analiza(frase);

        /* No debería ser reconocido como palíndromo: */
	frase="123";
        analiza(frase);

        /* Sí debería ser reconocido como palíndromo: */
        frase="aba";
        analiza(frase);

        /* Sí debería ser reconocido como palíndromo: */
        frase="abba";
        analiza(frase);

        /* No debería ser reconocido como palíndromo: */
        frase="Anatawa buta mitaini taberu";
        analiza(frase);

        /* No debería ser reconocido como palíndromo: */
        frase="xxmnzz";
        analiza(frase);

        /* Sí debería ser reconocido como palíndromo: */
        frase="a    aa";
        analiza(frase);
        
        /*Si deberia ser reconocido como palíndromo: */
        frase = "A n i T A LAVAlatinA";
        analiza(frase);
        /*Si deberia ser reconocido como palíndromo: */
        frase = "    A n i T A LAVAlatinA";
        analiza(frase);
        /*Si deberia ser reconocido como palíndromo: */
        frase = "3  2 1A n i T A LAVAlatinA123 0";
        analiza(frase);
    }

    /* Dada una frase, pregunta a otro método si la frase es o no es un
     * palíndromo y despliega el mensaje correspondiente: */
    private static void analiza(String frase) {
	if(esPalindromo(frase))
            System.out.println(frase+" es un palíndromo.");
	else
            System.out.println(frase+" no es un palíndromo.");
    }

    private static boolean esPalindromo(String frase) {
        String str = frase.toLowerCase();
        ArrayStack < Character > pila1 = new ArrayStack <Character> (str.length());
        ArrayStack < Character > pila2 = new ArrayStack <Character> (str.length());
        //Insertamos en pila1 los caracteres de izquierda a derecha
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c != ' ') pila1.push(c);
        }
        //Insertamos en pila2 los caracteres de derecha a izquierda
        for(int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if(c != ' ') pila2.push(c);
        }
        //Vamos a ir comparando caracteres en el orden normal e inverso para ver si todos coinciden
        boolean pal = true;
        while(!pila1.isEmpty() && pal == true) {
            if(pila1.peek().equals(pila2.peek())) {
                pila1.pop();
                pila2.pop();
            } else pal = false;
        }
        return pal;
    }
}
