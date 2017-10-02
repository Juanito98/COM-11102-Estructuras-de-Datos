/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglot;

/**
 *
 * @author juani
 */
public class ParkingLot {

    private static Car[] autos;
    private static ArrayStackLimitada < Car > estacionamiento;
    
    public static boolean hasCar(String p) {
        for (Car auto : autos) 
            if (auto.getOwner().equals(p)) 
                return true;
        return false;
    }
    
    public static boolean isCar(Car p) {
        for (Car auto : autos)
            if (auto.equals(p)) 
                return true;
        return false;
    }
    
    public static void takeCar(String p) {
        if(!hasCar(p)) {
            System.out.println(p + " no tiene coche.");
            return;
        }
        Car top;
        boolean found = false;
        ArrayStack < Car > waitCars = new ArrayStack<>(estacionamiento.size());
        while(!estacionamiento.isEmpty() && !found) {
            top = estacionamiento.pop();
            System.out.println("Sale auto:\n" + top);
            if(top.getOwner().equals(p)) {
                System.out.println("Encontrado auto de: " + p);
                found = true;
            } else {
                waitCars.push(top);
            }
        }
        if(!found) {
            System.out.println("Tu coche no estaba aquí " + p);
        }
        while(!waitCars.isEmpty()) {
            System.out.println("Regresa auto:\n" + waitCars.peek());
            estacionamiento.push(waitCars.pop());
        }
        System.out.println();
    }
    
    public static void parkCar(Car x) {
        if(!isCar(x)) {
            System.out.println(x + "\nEte carro no está registrado.");
        } else {
            try {
                estacionamiento.push(x);
            } catch(FullCollectionException e) {
                System.out.println(x + "\nNo se pudo estacionar.\n" + e + "\n");
                return;
            }
            System.out.println(x + "\nSe estacionó correctamente.\n");
        }
    }
    
    
    static Car newCar(String o, int id, String plates) {
        Car x;
        try {
            x = new Car(o, id, plates);
        } catch(MismatchException e) {
            System.out.println("\n" + e + "\n");
            //Interactuando con el usuario crearia un bucle hasta que carro x sea válido
            x = new Car("Juan Sigler", 123456, "H99UHP");
        }
        return x;        
    }
    
    public static void main(String[] args) {
        autos = new Car[10];
        estacionamiento = new ArrayStackLimitada <> (5);
        autos[0] = newCar("Persona1", 100041, "P14CAS");
        autos[1] = newCar("Persona2", 118467, "P14CAS");
        autos[2] = newCar("Persona3", 106334, "P14CAS");
        autos[3] = newCar("Persona4", 126500, "P14CAS");
        autos[4] = newCar("Persona5", 119169, "P14CAS");
        autos[5] = newCar("Persona6", 115724, "P14CAS");
        autos[6] = newCar("Persona7", 111478, "P14CAS");
        autos[7] = newCar("Persona8", 129358, "P14CAS");
        autos[8] = newCar("Persona9", 126962, "P14CAS");
        autos[9] = newCar("Persona10", 124464, "P14CAS");
        
        takeCar("Persona1");
        
        parkCar(autos[0]);
        parkCar(autos[2]);
        parkCar(autos[4]);
        parkCar(autos[6]);
        parkCar(autos[8]);
        parkCar(autos[7]);
        
        takeCar("Persona9");
        takeCar("Persona1");
        takeCar("Persona10");
        takeCar("Juanito Pérez");
    }
    
}
