package Day_1_Inverters;

public class PCU extends SolarInverter{
    private Battery battery;

    public PCU(int current, int operatingVoltage, int solarEfficiency, int batteryCapacity) {
        super(current, operatingVoltage, solarEfficiency);
        this.battery = new Battery(batteryCapacity);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("PCU Inverter with power rating: " + getPowerRating());
        System.out.println("Solar Panel efficiency: " + getSolarPanel().getEfficiency());
        System.out.println("Battery capacity: " + battery.getCapacity());
    }
}

