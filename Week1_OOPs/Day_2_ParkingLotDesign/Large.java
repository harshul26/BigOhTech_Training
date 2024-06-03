package Day_2_ParkingLotDesign;

class Large extends ParkingSpot {
    private Vehicle truck = new Truck();
    private boolean occupied;
    private int place;

    public Large() {}

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

    public Vehicle getTruck(){
        return truck;
    }
}
