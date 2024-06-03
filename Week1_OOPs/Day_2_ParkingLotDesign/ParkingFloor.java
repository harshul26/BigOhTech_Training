package Day_2_ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

class ParkingFloor {
    private List<ParkingSpot> parkingSpots;
    private List<Compact> compactSpots;
    private List<Large> largeSpots;
    private List<Handicapped> handicappedSpots;
    private List<MotorCycleSpot> motorCycleSpots;
    private List<ElectricCarSpot> electricCarSpots;
    private int parkingSpotsCount;
    private List<List<Integer>> userPaidID; // user paid through exit panels
    private int numOfEntryPoints, numOfExitPoints;
    private int floor;

    //public ParkingFloor() {}

    public ParkingFloor(int maxParkingSpots, int numOfEntryPoints, int numOfExitPoints, int floor) {
        this.parkingSpots = new ArrayList<>(maxParkingSpots);
        this.compactSpots = new ArrayList<>();
        this.largeSpots = new ArrayList<>();
        this.handicappedSpots = new ArrayList<>();
        this.motorCycleSpots = new ArrayList<>();
        this.electricCarSpots = new ArrayList<>();
        this.userPaidID = new ArrayList<>();
        this.numOfEntryPoints = numOfEntryPoints;
        this.numOfExitPoints = numOfExitPoints;
        this.floor = floor;
    }

    public int addParkingSpot(int spotLocation) {
        parkingSpots.get(spotLocation).spotUnoccupy();
        this.parkingSpotsCount += 1;
        return this.parkingSpotsCount;
    }

    public int removeParkingSpot(int spotLocation) {
        parkingSpots.get(spotLocation).spotOccupy();
        this.parkingSpotsCount -= 1;
        return this.parkingSpotsCount;
    }

    public List<ParkingSpot> getParkingSpots() {
        return this.parkingSpots;
    }

    public void displayParkingSpots() {
        System.out.println("Number of parking Spots: " + parkingSpotsCount);
    }

    public void paidUsingExitPanel(int userID, int exitPoint) {
        userPaidID.get(exitPoint).add(userID);
    }

    public int getFloor() {
        return floor;
    }

    public List<Compact> getCompactSpots(){
        return compactSpots;
    }
    public List<Large> getLargeSpots(){
        return largeSpots;
    }

    public List<Handicapped> getHandicappedSpots(){
        return handicappedSpots;
    }

    public List<MotorCycleSpot> getMotorCycleSpots(){
        return motorCycleSpots;
    }

    public List<ElectricCarSpot> getElectricCarSpots(){
        return electricCarSpots;
    }

    public int getNumOfEntryPoints(){
        return numOfEntryPoints;
    }

    public int getNumOfExitPoints(){
        return numOfExitPoints;
    }
}

