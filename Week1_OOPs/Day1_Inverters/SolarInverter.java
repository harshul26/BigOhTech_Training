package Day_1_Inverters;

abstract class SolarInverter extends Inverters{

    private SolarPanel solarPanel;

    public SolarInverter(int current, int operatingVoltage, int solarEfficiency) {
        super(current, operatingVoltage);
        this.solarPanel = new SolarPanel(solarEfficiency);
    }

    public SolarPanel getSolarPanel() {
        return solarPanel;
    }
}
