/**
 * Taxi.java
 *
 * A class that represents a taxi.  It is a subclass of Automobile.
 *
 * It inherits fields and methods from Automobile and Vehicle.
 *
 * Computer Science 112
 */

 public class Taxi extends Automobile {
    private String taxiID;
    private double fareTotal;
    private int numFares;

    public Taxi(String make, String model, int year, String id) {
        // Invoke the Automobile constructor to initialize
        // the fields inherited from Automobile and Vehicle.
        // Note that we assume that the taxi is not an SUV and has 5 seats.
        super(make, model, year);
        
        this.taxiID = id;
        this.fareTotal = 0.0;
        this.numFares = 0;
    }
 
    /*** accessors ***/
    // getMake(), getModel(), etc. are inherited from Vehicle.
    // getNumSeats() and isSUV(), etc. are inherited from Automobile.

    public String getID() {
        return this.taxiID;
    }

    public double getFareTotal() {
        return this.fareTotal;
    }
    
    public int getNumFares() {
        return this.numFares;
    }

    /**
     * getAverageFare - computes and returns the average fare collected by the taxi
     */
    public double getAverageFare() {
        if (this.numFares == 0) {
            System.out.println("no fares collected");
            return -1.0;
        }
     
        return this.fareTotal/this.numFares;
    }
    
    /*** mutators ***/
    
    /**
     * setID - change this Taxi object's ID string to the specified id
     * 
     * XXX: should add some error-checking
     */
    public void setID(String id) {
        this.taxiID = id;
    }
    
    /**
     * addFare - incorporate the specified fare into the total fare and 
     * the number of fares for this Taxi
     */
    public void addFare(double fare) {
        if (fare < 0) {
            throw new IllegalArgumentException();
        }
            
        this.fareTotal += fare;
        this.numFares++;
    }
    
    /**
     * resetFareInfo - resets the fare information for this Taxi.
     * Could be used at the start of a given day, week, etc.
     */
    public void resetFareInfo() {
        this.fareTotal = 0;
        this.numFares = 0;
    }
    
    /*
     * Creates a string that can be used when printing
     * a Taxi object.  This method overrides the 
     * toString() method inherited from the Automobile class.
     */
    public String toString() {
        return "Taxi (id = " + this.taxiID + ")";
    }
}