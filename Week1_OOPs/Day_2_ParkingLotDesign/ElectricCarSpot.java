package Day_2_ParkingLotDesign;

class ElectricCarSpot extends ParkingSpot {
    private Vehicle electricCar = new ElectricCar();
    private int charge;
    private boolean occupied;
    private int place;

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

    public Vehicle getElectricCar(){
        return electricCar;
    }

    public int getCharge(){
        return charge;
    }
}