package Day_1_Inverters;

public class Regalia extends SolarInverter{
    public Regalia(int current, int operatingVoltage, int solarEfficiency) {
        super(current, operatingVoltage, solarEfficiency);
    }

    @Override
    public void displayInfo() {
        System.out.println("Regalia Inverter with power rating: " + getPowerRating());
        System.out.println("Solar Panel efficiency: " + getSolarPanel().getEfficiency());
    }
    
}
