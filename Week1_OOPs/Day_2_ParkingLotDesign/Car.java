package Day_2_ParkingLotDesign;

class Car extends Vehicle {
    private String nameplate;

    public Car() {}

    public Car(String nameplate) {
        this.nameplate = nameplate;
    }

    public String getNameplate(){
        return nameplate;
    }
}
