package Day_1_Inverters;

public class GTI extends SolarInverter{
    public GTI(int current, int operatingVoltage, int solarEfficiency) {
        super(current, operatingVoltage, solarEfficiency);
    }

    public void gridOn() {
        System.out.println("GTI Inverter is selling extra energy back to the grid.");
    }
    
    @Override
    public void displayInfo() {
        System.out.println("GTI Inverter with power rating: " + getPowerRating());
        System.out.println("Solar Panel efficiency: " + getSolarPanel().getEfficiency());
        gridOn();
    }
}
