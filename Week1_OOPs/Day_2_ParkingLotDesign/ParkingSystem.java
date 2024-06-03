package Day_2_ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

class ParkingSystem {
    private int maxParkingFloor;
     private int maxParkingAttendant;
    private List<ParkingAttendant> parkingAttendants;
    private List<ParkingFloor> parkingFloors;
    private List<Customer> customers;
    private Price fee;
    Admin admin;


    //public ParkingSystem() {}

    public ParkingSystem(int maxParkingFloor, int maxParkingAttendant , Admin admin) {
        this.maxParkingFloor = maxParkingFloor;
        this.maxParkingAttendant = maxParkingAttendant;
        this.parkingFloors = new ArrayList<>(maxParkingFloor);
        this.parkingAttendants = new ArrayList<>(maxParkingAttendant);
        this.customers = new ArrayList<>();
        this.fee = new Price();
        this.admin = admin;
    }

    public boolean addParkingFloor(ParkingFloor parkingFloor , User admin) {
        if(admin instanceof Admin){
            if (parkingFloors.size() == maxParkingFloor) {
                return false;
            }
            parkingFloors.add(parkingFloor);
            return true;
        }

        return false;  
    }


    public boolean removeParkingFloor(int floor , Admin admin) {
        if(admin instanceof Admin){
            for (int i = 0; i < parkingFloors.size(); i++) {
                if (floor == parkingFloors.get(i).getFloor()) {
                    parkingFloors.remove(i);
                    return true;
                }
            }
        }

        return false;  
    }

    public int removeSpotFromFloor(int floor, int spotLocation , Admin admin) {
        return parkingFloors.get(floor).removeParkingSpot(spotLocation);
    }

    public int addSpotInFloor(int floor, int spotLocation, Admin admin) {
        return parkingFloors.get(floor).addParkingSpot(spotLocation);
    }

    public int addParkingAttendant(ParkingAttendant parkingAttendant, Admin admin) {
        maxParkingAttendant += 1;
        parkingAttendants.add(parkingAttendant);
        return maxParkingAttendant;
    }

    public int removeParkingAttendant(int attendantID, Admin admin) {
        int idx = 0;
        for (ParkingAttendant parkingAttendant : parkingAttendants) {
            if (parkingAttendant.getUserId() == attendantID) {
                break;
            }
            idx++;
        }
        parkingAttendants.remove(idx);
        maxParkingAttendant -= 1;
        return maxParkingAttendant;
    }

    public boolean parkingSpotAvailable(Vehicle vehicle, Admin admin) {
        boolean available = false;
        for (ParkingFloor floor : parkingFloors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (!spot.isOccupied()) {
                    available = true;
                    break;
                }
            }
        }
        return available;
    }

    public boolean addCustomer(Customer customer) {
        Vehicle vehicle = customer.getVehicle();
        if (this.parkingSpotAvailable(vehicle, admin)) {
            customers.add(customer);
            for (ParkingFloor floor : parkingFloors) {
                List<ParkingSpot> parkingSpots = floor.getParkingSpots();
                for (ParkingSpot spot : parkingSpots) {
                    if (!spot.isOccupied()) {
                        this.removeSpotFromFloor(floor.getFloor(), spot.getSpot() , admin);
                        break;
                    }
                }
            }
            customers.get(customers.size() - 1).checkInTime((int) (Math.random() * 10 + 1));
            return true;
        }
        return false;
    }

    public boolean removeCustomer(Customer customer, ParkingSpot parkingSpot, ParkingFloor parkingFloor , Admin admin) {
        int idx = 0;
        for (Customer c : customers) {
            if (c.getUserId() == customer.getUserId()) {
                break;
            }
            idx++;
        }
        if (idx == customers.size()) {
            return false;
        }
        customers.get(idx).checkOutTime(10); // right now the checkout time is static
        parkingFloors.get(parkingFloor.getFloor()).addParkingSpot(parkingSpot.getSpot()); // unoccupy the spot
        return true;
    }

    public int chargePay(Customer customer , ParkingAttendant pA) {
        return fee.charge(customer.getCheckInTime(), customer.getCheckOutTime());
    }

    public int addPayment(Customer customer, String feesPaidTo, ParkingAttendant parkingAttendant) {
        int idx = 0;
        for (ParkingAttendant pa : parkingAttendants) {
            if (pa.getUserId() == parkingAttendant.getUserId()) {
                break;
            }
            idx++;
        }
        if ("parkingattendant".equals(feesPaidTo)) {
            parkingAttendants.get(idx).userPaid(customer.getUserId());
        }
        return 0;
    }

    private int parkingRate;
    private Price price;


    public int addParkingRate(int rate) {
        this.parkingRate += rate;
        return this.parkingRate;
    }

    public int modifyParkingRate(int parkingRate) {
        this.parkingRate = parkingRate;
        return this.parkingRate;
    }

    public Price getPrice(){
        return price;
    }

    public void setParkingRate(int parkingRate) {
        this.parkingRate = parkingRate;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
