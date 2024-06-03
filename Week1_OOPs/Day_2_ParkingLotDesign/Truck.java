package Day_2_ParkingLotDesign;

class Truck extends Vehicle {
    private String nameplate;

    public Truck() {}

    public Truck(String nameplate) {
        this.nameplate = nameplate;
    }
    public String getNameplate(){
        return nameplate;
    }
}