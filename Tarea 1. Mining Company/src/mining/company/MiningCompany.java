package mining.company;
import java.util.*;
/**
 *
 * @author jsiglerp
 */
public class MiningCompany {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static int getValidInteger(int a, int b) { 
        int x = a - 1;
        do {
            try { x = sc.nextInt(); }
            catch(Exception e) { sc.next(); }
            if(x < a || x > b) System.out.print("No es un entero válido.\nIntente de nuevo: ");
        } while(x < a || x > b);
        return x;
    }
    
    public static double getValidDouble(double a, double b) { 
        double x = a - 1;
        do {
            try { x = sc.nextDouble(); }
            catch(Exception e) { sc.next(); }
            if(x < a || x > b) System.out.print("No es un número válido.\nIntente de nuevo: ");
        } while(x < a || x > b);
        return x;
    }
    
    public static Truck getValidTruck() {
        System.out.println("Seleccione el tipo del camión");
        System.out.println("1. Camión de pasajeros");
        System.out.println("2. Camión de volteo");
        int x = getValidInteger(1, 2);
        String brand, motorSerie, plates;
        System.out.print("Ingrese marca: ");
        brand = sc.next();
        System.out.print("Ingrese número del motor: ");
        motorSerie = sc.next();
        System.out.print("Ingrese las placas del camión: ");
        plates = sc.next();
        if(x == 1) {
            System.out.print("Ingrese la máxima capacidad de personas: ");
            int capacity = getValidInteger(0, Integer.MAX_VALUE);
            return new PassengerTruck(brand, motorSerie, plates, capacity);
        } else {
            System.out.print("Ingrese la capacidad (en toneladas): ");
            double capacity = getValidDouble(0, Double.MAX_VALUE);
            return new GroundTruck(brand, motorSerie, plates, capacity);
        }
    }

    public static int consult() {
        System.out.println("- - - Menú de opciones - - -");
        System.out.println("\t< 1 > Consultar camiones de pasajeros");
        System.out.println("\t< 2 > Consultar camiones de volteo");
        System.out.println("\t< 3 > Actualizar capacidad de algun camión de volteo");
        System.out.println("\t< 4 > Calcular cantidad total de camiones de pasajeros de alguna marca");
        System.out.println("\t< 5 > Calcular cantidad posible de tierra para transportar");
        System.out.println("\t< 0 > Salir");
        System.out.print("Seleccione una opción: ");
        int x = getValidInteger(0, 5);
        return x;
    }
    
    public static void main(String[] args) {
        System.out.print("Ingrese el número total de camiones: ");
        int n = getValidInteger(0, Integer.MAX_VALUE);
        TruckList L = new TruckList(n);
        for(int i = 0; i < n; i++) {
            System.out.println("Camión " + (i + 1) + ":");
            L.arr[i] = getValidTruck();
        }
        int x = consult();
        while(x != 0) {
            switch(x) {
                case 1: 
                    L.printPassengerTrucks(); 
                    break;
                case 2: 
                    L.printGroundTrucks(); 
                    break;
                case 3: 
                    System.out.print("Ingresa las placas del camión a actualizar: ");
                    String plates = sc.next();
                    System.out.print("Ingresa la nueva capacidad del camión: ");
                    L.changeGroundTruckCapacity(plates, getValidDouble(0, Double.MAX_VALUE)); 
                    break;
                case 4: 
                    System.out.print("Ingresa marca a contar: ");
                    System.out.println("Hay " + L.passengerTrucksWithSomeBrand(sc.next()) + " camiones con esa marca."); 
                    break;
                case 5: 
                    System.out.println("Se pueden transportar " + L.totalAmountOfGround() + " toneladas de tierra.");
                    break;
                default: break;
            }
            x = consult();
        }
    }
    
}

/* Example Case
10
1
CHEVROLET
165PCS
YCZ-230
6
1
CHEVROLET
1z69ltS
ABS-230
32
1
FORD
g6g5PxS
ECH-H30
20
1
CHEVROLET
f65dfsCS
CHE-3Y0
14
1
VOLVO
34zpHza
1CR-ACK
43
2
Mercedes-Benz
4Jr3gKR
6632-AAI
6.4
2
Mercedes-Benz
J3rLk5w
888-ABC
32.01
2
RENAULT TRUCKS
9n3DSF2
999-ZZZ
20.98
2
HYUNDAI
0khNJ1
DZG-20-01
14
2
VOLVO
u3bnKW
FRI-DAY
13.12
*/