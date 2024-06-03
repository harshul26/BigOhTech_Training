package Day_2_ParkingLotDesign;

public class ParkingLotDesignRunner {
    public static void main(String[] args) {
        Admin admin = new Admin("abc" , 25 , 012);
        Vehicle vehicle = new Vehicle(1);
        Customer customer = new Customer(null, 0, 0, vehicle, "CASH");
        ParkingSystem parkingSystem = new ParkingSystem(5, 5 , admin );

        System.out.println(parkingSystem.addCustomer(customer));

        ParkingFloor parkingFloor = new ParkingFloor(10 , 2 ,2 , 2);
        
        System.out.println(parkingSystem.addParkingFloor(parkingFloor , admin));

    
    }
    
}
