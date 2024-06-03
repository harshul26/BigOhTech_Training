package Day_2_ParkingLotDesign;

class ElectricCar extends Car {
    private String color;

    public ElectricCar() {}

    public ElectricCar(String color) {
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}