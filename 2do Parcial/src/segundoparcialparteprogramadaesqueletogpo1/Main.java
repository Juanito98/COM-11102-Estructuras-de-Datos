package segundoparcialparteprogramadaesqueletogpo1;

public class Main {
    public static void main(String[] args) {
       Olimpiada o0=new Olimpiada("México", 1968);
       Olimpiada o1=new Olimpiada("Montreal", 1976);
       Olimpiada o2=new Olimpiada("Atlanta", 1996);
       Olimpiada o3=new Olimpiada("Los Ángeles", 1984);
       Olimpiada o4=new Olimpiada("Los Ángeles", 1932);
       Olimpiada o5=new Olimpiada("Moscú", 1980);
       Olimpiada o6=new Olimpiada("Barcelona", 1992);
       Olimpiada o7=new Olimpiada("Atenas", 2004);

       // Debería imprimir: México 1968, Montreal 1976, Atlanta 1996, Los
       // Ángeles 1932, Los Ángeles 1984 (no necesariamente en ese orden):
       ArraySet<Olimpiada> america=new ArraySet<Olimpiada>();
       america.add(o0);
       america.add(o1);
       america.add(o2);
       america.add(o3);
       america.add(o4);
       System.out.println("Olimpiadas de América:\n"+america);

       // Debería imprimir: Moscú 1980, Barcelona 1992, Atenas 2004 (no
       // necesariamente en ese orden):
       ArraySet<Olimpiada> europa=new ArraySet<Olimpiada>();
       europa.add(o5);
       europa.add(o6);
       europa.add(o7);
       System.out.println("Olimpiadas de Europa:\n"+europa);

       // Debería imprimir: Montreal 1976, Moscú 1980 (no necesariamente en
       // ese orden):
       ArraySet<Olimpiada> emes=new ArraySet<Olimpiada>();
       emes.add(o0);
       emes.add(o1);
       emes.add(o5);
       System.out.println("Olimpiadas en ciudades cuyo nombre comienza con 'm':\n"+emes);

       // Debería imprimir: México 1968, Montreal 1976 (no necesariamente en ese orden):
       SetADT<Olimpiada> americaConEme;
       americaConEme=america.intersection(emes);
       System.out.println("Olimpiadas en América en ciudades cuyo nombre comienza con 'm':\n"+americaConEme);

       // Debería imprimir: México 1968, Montreal 1976, Atlanta 1996, Los Ángeles 1932,
       // Los Ángeles 1984, Moscú 1980, Barcelona 1992, Atenas 2004 (no necesariamente
       // en ese orden):
       SetADT<Olimpiada> todas;
       todas=america.union(europa);
       System.out.println("Todas las olimpiadas en América y Europa:\n"+todas);

       // Debería imprimir: Barcelona 1992, Atenas 2004 (no necesariamente en ese
       // orden):
       SetADT<Olimpiada> europaSinEme;
       europaSinEme=europa.difference(emes);
       System.out.println("Olimpiadas en Europa en ciudades cuyo nombre no comienza con 'm':\n"+europaSinEme);
    }
}
