package Day_1_Inverters;

public class iCruze extends SimpleHomeInverter{
    public iCruze(int current, int operatingVoltage, int batteryCapacity) {
        super(current, operatingVoltage, batteryCapacity);
    }

    @Override
    public void displayInfo() {
        System.out.println("iCruze Inverter with power rating: " + getPowerRating());
        System.out.println("Battery capacity: " + super.battery.getCapacity());
    }
    
}
