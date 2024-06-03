package Day_1_Inverters;

abstract class Inverters {
    private int current;
    private int operatingVoltage;

    public Inverters(int current , int operatingVoltage){
        this.current = current;
        this.operatingVoltage = operatingVoltage;
    }

    public int getPowerRating() {
        return current * operatingVoltage;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();
    
}
