package Day_2_ParkingLotDesign;

class Wheelchair extends Vehicle {
    private int size;

    public Wheelchair() {}

    public Wheelchair(int size) {
        this.size = size;
    }

    public int getSize(){
        return size;
    }
}