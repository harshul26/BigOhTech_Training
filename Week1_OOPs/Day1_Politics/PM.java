package Day_1_Politics;

public class PM extends Ministers{
    AircraftDrivers airDriver;

    public PM(String name , String constituency , AircraftDrivers ad , Drivers d){
        super(name , constituency, d);
        this.airDriver = ad;
        this.spendingLimit = 10000000;
    }
    public boolean giveArrestPermission(Ministers minister){
        return minister.exceedsSpeedLimit();
    }
}
