package Day_2_ParkingLotDesign;

class Compact extends ParkingSpot {
    private Vehicle car = new Car();
    private boolean occupied;
    private int place;

    public Compact() {}

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

    public Vehicle getCar(){
        return car;
    }
}
