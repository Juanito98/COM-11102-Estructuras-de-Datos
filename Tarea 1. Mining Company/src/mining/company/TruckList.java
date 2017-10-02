package mining.company;

public class TruckList {
    private final int n;
    protected Truck[] arr;
    public TruckList(int s) { this.n = s; arr = new Truck[n]; }
    
    public void printPassengerTrucks() {
        System.out.println("- - - Camiones de Pasajeros - - -\n");
        for(int i = 0; i < n; i++) {
            if(this.arr[i].getClass().getSimpleName().equals("PassengerTruck"))
                System.out.println(this.arr[i] + "\n");
        }
    }
    
    public void printGroundTrucks() {
        System.out.println("- - - Camiones de Volteo - - -\n");
        for(int i = 0; i < this.n; i++) {
            if(this.arr[i].getClass().getSimpleName().equals("GroundTruck"))
                System.out.println(this.arr[i] + "\n");
        }
    }
    
    public void changeGroundTruckCapacity(String plates, double v) {
        boolean f = false;
        for(int i = 0; i < this.n; i++) {
            if(this.arr[i].getClass().getSimpleName().equals("GroundTruck") && this.arr[i].getPlates().equals(plates)) { 
                f = true;
                ((GroundTruck) this.arr[i]).setCapacity(v);
            }
        }
        if(f == false) System.out.println("No se encontraron las placas.");
        else System.out.println("Done.");
    }
    
    public int passengerTrucksWithSomeBrand(String brand) {
        int c = 0;
        for(int i = 0; i < this.n; i++) {
            if(this.arr[i].getClass().getSimpleName().equals("PassengerTruck") && this.arr[i].getBrand().equals(brand)) 
                c++;
        }
        return c;
    }
    
    public double totalAmountOfGround() {
        double s = 0;
        for(int i = 0; i < this.n; i++) {
            if(this.arr[i].getClass().getSimpleName().equals("GroundTruck")) 
                s += ((GroundTruck) this.arr[i]).getCapacity();
        }
        return s;
    }
}
