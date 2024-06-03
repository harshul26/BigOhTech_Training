package testAssignment;

import java.util.Map;

public class HotelSystem {

    private HotelManagement hotelManager;
    private UserManagement userManager;
    private Customer_AND_HotelManagement customerHotelMiddleware;

    public HotelSystem(){
        this.hotelManager = new HotelManagement();
        this.userManager = new UserManagement();
        this.customerHotelMiddleware = new Customer_AND_HotelManagement(userManager, hotelManager);
    }

    public HotelManagement getHotelManager(){
        return hotelManager;
    }

    public UserManagement getUserManager(){
        return userManager;
    }

    public Customer_AND_HotelManagement getMiddleware(){
        return customerHotelMiddleware;
    }

    public boolean approveHotelsAddByHotelAgent(Hotel_Agent agent , Administrator admin){
        //admin can add those hotels in the system that are approved by the hotel-agent
            Map<Integer , Hotel> hotels = agent.getListOfHotels();
            for(Hotel hotel : hotels.values()){
                this.getHotelManager().addHotel(hotel, admin);
            }
            return true;
    }
    
}
