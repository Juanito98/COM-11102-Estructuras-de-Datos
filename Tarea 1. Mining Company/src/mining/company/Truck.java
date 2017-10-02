package mining.company;
/**
 *
 * @author jsiglerp
 */
public class Truck {
    private String brand, motorSerie, plates;
    public Truck() {}
    public Truck(String b, String m, String p) { this.brand = b; this.motorSerie = m; this.plates = p; }
    public String getPlates() { return this.plates; }
    public String getBrand() { return this.brand; }
    public String toString() { return "Marca: " + brand + "\nNúmero de motor: " + motorSerie + "\nPlacas: " + plates; } 
}
