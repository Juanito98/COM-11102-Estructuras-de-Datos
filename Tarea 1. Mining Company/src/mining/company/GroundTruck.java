package mining.company;
/**
 *
 * @author jsiglerp
 */
public class GroundTruck extends Truck {
    double maxCapacity;
    public GroundTruck() {}
    public GroundTruck(String m, String n, String p, double v) { super(m, n, p); this.maxCapacity = v; }
    public double getCapacity() { return this.maxCapacity; }
    public void setCapacity(double v) { this.maxCapacity = v; }
    public String toString() { return super.toString() + "\nCapacidad (en toneladas): " + maxCapacity; }
}
