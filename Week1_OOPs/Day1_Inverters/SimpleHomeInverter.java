package Day_1_Inverters;

//non-solar inverter
public class SimpleHomeInverter extends Inverters{
    protected Battery battery;

    public SimpleHomeInverter(int current, int operatingVoltage, int batteryCapacity) {
        super(current, operatingVoltage);
        this.battery = new Battery(batteryCapacity);
    }

    @Override
    public void displayInfo() {
        System.out.println("Simple Home Inverter with power rating: " + getPowerRating());
        System.out.println("Battery capacity: " + battery.getCapacity());
    }
    
}
