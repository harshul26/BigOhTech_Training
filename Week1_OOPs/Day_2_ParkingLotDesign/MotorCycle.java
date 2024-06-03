package Day_2_ParkingLotDesign;

class MotorCycle extends Vehicle {
    private String nameplate;

    public MotorCycle() {}

    public MotorCycle(String nameplate) {
        this.nameplate = nameplate;
    }

    public String getNameplate(){
        return nameplate;
    }
}