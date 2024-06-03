package Day_2_ParkingLotDesign;

class Customer extends User {
    private Vehicle vehicle;
    private String paymentType;
    private int checkIn;
    private int checkOut;
    private String paidTo;
    private int paidFee;
    private ParkingFloor parkingFloor;
    private ParkingSpot parkingSpot;
    private ParkingAttendant parkingAttendant;

    public Customer(String name, int age, int id , Vehicle vehicle, String paymentType) {
        super(name, age, id);
        this.vehicle = vehicle;
        this.paymentType = paymentType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int checkOutTime(int time) {
        checkOut = time;
        return checkOut;
    }

    public int checkInTime(int time) {
        checkIn = time;
        return checkIn;
    }

    public int getCheckOutTime() {
        return checkOut;
    }

    public int getCheckInTime() {
        return checkIn;
    }

    public void payment(String paidTo, int fees) {
        this.paidTo = paidTo;
        this.paidFee = fees;
        parkingAttendant.userPaid(this.getUserId());
    }

    public String feesPaidTo() {
        return paidTo;
    }

    public int amountPaid() {
        return paidFee;
    }

    public String getPaymentType(){
        return paymentType;
    }

    public ParkingFloor getParkingFloor(){
        return parkingFloor;
    }

    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    }
}
