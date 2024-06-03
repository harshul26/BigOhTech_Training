package Day_2_ParkingLotDesign;


class Handicapped extends ParkingSpot {
    private Vehicle wheelchair = new Wheelchair();
    private boolean occupied;
    private int place;

    public Handicapped() {}

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
    public Vehicle getWheelchair(){
        return wheelchair;
    }
}
