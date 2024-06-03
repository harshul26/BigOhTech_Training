package testAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelManagement {
    private Map<Integer , Hotel> hotels;
    private List<RoomBooking> listOfRoomsBooked;
    

    public HotelManagement(){
        this.hotels = new HashMap<>();
        this.listOfRoomsBooked = new ArrayList<>();
    }
    
    //Only Admin can add the details of a hotel
    public boolean addHotel(Hotel newHotel , Person admin){
        if(admin instanceof Administrator){
            if(!hotels.containsKey(newHotel.getId())){
                hotels.put(newHotel.getId(), newHotel);
                return true;
            }
        }
        return false;
    }

    //Only Admin can remove the details of a hotel
    public boolean deleteHotel(Hotel hotel , Person admin){
        if(admin instanceof Administrator){
            if(hotels.containsKey(hotel.getId())){
                hotels.remove(hotel.getId());
                return true;
            }
        }
        return false;
    }

    //details of hotels
    public void displayDetailsOfHotels(){
        for(Hotel hotel : hotels.values()){
            hotel.displayDetails();
        }
    }

    public Map<Integer , Hotel> getHotels(){
        return hotels;
    }

    //booking a room if available
    public boolean addBookings(RoomBooking booking){
        if(!listOfRoomsBooked.contains(booking)){
            listOfRoomsBooked.add(booking);
            return true;
        }
        return false;
    }

    //displaying booked room details
    public void showDetailsOfBookings(){
        for(RoomBooking booking : listOfRoomsBooked){
            booking.bookinDetails();
        }
    }

    //taking feedback from the user
    //feedback of which hotel by a specific customer is saved in a map
    public boolean takingFeedback(Customer customer , String feedbackMessage , Hotel hotelForFeedback){
        for(Hotel hotel : hotels.values()){
            if(hotel.getId() == hotelForFeedback.getId()){
                hotel.getFeedbackList().put(customer, feedbackMessage);
            }
        }
        return true;
    }

    

}
