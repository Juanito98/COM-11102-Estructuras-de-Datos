package mining.company;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jsiglerp
 */
public class PassengerTruck extends Truck {
    int maxCapacity;
    public PassengerTruck() {}
    public PassengerTruck(String m, String n, String p, int s) { super(m, n, p); this.maxCapacity = s; }
    public String toString() { return super.toString() + "\nCapacidad de pasajeros: " + maxCapacity; }
}
