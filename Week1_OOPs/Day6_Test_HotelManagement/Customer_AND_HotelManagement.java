package testAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer_AND_HotelManagement {

    //it is a sort of middle ware b/w User and Hotel in the system for middle functionalities
    private UserManagement userManager;
    private HotelManagement hotelmanager;
    private Map<Integer , Hotel> hotels;
    
    //constructor
    public Customer_AND_HotelManagement(UserManagement userManager, HotelManagement hotelmanager) {
        this.userManager = userManager;
        this.hotelmanager = hotelmanager;
        this.hotels = hotelmanager.getHotels();
    }

    //Customer can search for the hotel based on name and address
    public List<String> search(String name , String address , Customer person){
        List<String> foundHotels = new ArrayList<>();
        if(person instanceof Customer){
            //searching based on name
            if(name != null){
                for(Hotel hotel : hotels.values()){
                    if(hotel.getName().equals(name)){
                        foundHotels.add(hotel.getName() + " " + hotel.getLocations());
                    }
                }
            }

            //searching based on address
            if(address != null){
                for(Hotel hotel : hotels.values()){
                    for(AdditionalDetailsOfHotel location : hotel.getLocations().values()){
                        if(location.getAddress().equals(address)){
                            foundHotels.add(hotel.getName() + " " + hotel.getLocations());
                        }
                    }
                }
            }
        }
        
        return foundHotels;
    }

    //customer can book hotel with checkin date and checkout date
    public boolean createBooking(Customer user , Hotel hotel , String checkInDate , String checkOutDate){
        if(!userManager.isUserAvailable(user)){
            return false;
        }

        Map<Integer , Hotel> hotels = hotelmanager.getHotels();
        AdditionalDetailsOfHotel detailsHotel = hotel.getLocations().values().iterator().next();
        Rooms room = detailsHotel.getRoomObjects().values().iterator().next();
        int roomID = room.getId();

        if(hotels.containsKey(hotel.getId())){
            Map<Integer , AdditionalDetailsOfHotel> consumedAddress = hotels.get(hotel.getId()).getDetailsObject();
            if(consumedAddress.containsKey(detailsHotel.getId())){
                Map<Integer , Rooms> consumedRoom = consumedAddress.get(detailsHotel.getId()).getRoomObjects();
                if(consumedRoom.containsKey(roomID) && room.isFilled()){
                    userManager.checkedIn(user);
                    hotelmanager.addBookings(new RoomBooking(user, room, checkInDate, checkOutDate));
                    consumedRoom.get(roomID).occupyTheRoom();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean feedbackOfHotel(Customer customer , Hotel hotel , String message){

        hotelmanager.takingFeedback(customer , message , hotel);
        return true;
    }
}
