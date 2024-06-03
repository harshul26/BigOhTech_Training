package Day_2_ParkingLotDesign;

class MotorCycleSpot extends ParkingSpot {
    private Vehicle motorCycle = new MotorCycle();
    private boolean occupied;
    private int place;

    public MotorCycleSpot() {}

    @Override
    public void spotOccupy() {
        occupied = true;
    }

    @Override
    public void spotUnoccupy() {
        occupied = false;
    }

    @Override
    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public int getSpot() {
        return place;
    }
    public Vehicle getMotorCycle(){
        return motorCycle;
    }
}