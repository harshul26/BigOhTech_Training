package Day_2_ParkingLotDesign;

class ParkingSpot {
    private int place;
    private boolean occupied;

    public ParkingSpot() {}

    public ParkingSpot(int place) {
        this.place = place;
        this.occupied = false;
    }

    public void spotOccupy() {
        occupied = true;
    }

    public void spotUnoccupy() {
        occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public int getSpot() {
        return place;
    }
}