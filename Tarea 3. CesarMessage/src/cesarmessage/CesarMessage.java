/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cesarmessage;
/**
 *
 * @author JSIGLERP
 */
public class CesarMessage {
    public static final int MOD = 'Z' - 'A' + 1;
    // Encripta string dado una llave
    public static String encrypt(String st, int[] key) {
        ArrayQueue < Integer > cola = new ArrayQueue<>();
        for(int i = 0; i < key.length; i++) cola.enqueue(key[i]);
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < st.length(); i++) {
            if(st.charAt(i) >= 'A' && st.charAt(i) <= 'Z') {
                int c = st.charAt(i)-'A' + (cola.first() % MOD) + MOD;
                c %= MOD;
                c += 'A';
                res.append((char)c);
                cola.enqueue(cola.dequeue());
            } else res.append(st.charAt(i));
        }
        return res.toString();
    }
    
    // Desencripta un string dado la llave con que se encriptó
    public static String decrypt(String st, int[] key) {
        int[] inverseKey = new int[key.length];
        for(int i = 0; i < key.length; i++) 
            inverseKey[i] = key[i] * -1;
        return encrypt(st, inverseKey);
    }
    
    public static void main(String[] args) {
        int[] llave = {69, 6, 25, -13, -34, 4 };
        
        String st = "ITAM";
        st = encrypt(st, llave); 
        System.out.println(st);
        st = decrypt(st, llave);
        System.out.println(st);
        
        st = "DK FHKXRT KNK IJZQHUXLXZF VI UGSBK";
        st = decrypt(st, llave);
        System.out.println(st);
        
    }
    
}
