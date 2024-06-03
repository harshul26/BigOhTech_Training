package Day_1_Politics;

public class Politics_Runner {
    public static void main(String[] args) {
        Drivers d1 = new Drivers("Driver1");
        Drivers d2 = new Drivers("Driver2");
        Drivers d3 = new Drivers("Driver3");
        AircraftDrivers ad1 = new AircraftDrivers("AircraftDriver1");
        MP mp = new MP("MP1", "C1", d1);
        mp.addExpense(1_50_000);
        Ministers minister = new Ministers("Minister1", "C2", d2);
        minister.addExpense(12_00_000);
        PM pm = new PM("PM1", "C3", ad1, d3);
        Commisioner com = new Commisioner("Commisioner1");

        com.canArrest(mp , pm);
    }
    
}
