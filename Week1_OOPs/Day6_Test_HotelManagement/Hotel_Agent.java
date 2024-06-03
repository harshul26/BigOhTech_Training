package testAssignment;

import java.util.HashMap;
import java.util.Map;

public class Hotel_Agent extends Person{
    //hotel agent is derived from the Person , can add/update the details of the hotel in the system
    // and can modify its own details

    Map<Integer , Hotel> listOfHotels;

    public Hotel_Agent(int pId, int pAge, String pName, String pAddress, String pEmail, Long phoneNo, Hotel hotels) {
        super(pId, pAge, pName, pAddress, pEmail, phoneNo);
        this.listOfHotels = new HashMap<>();
    }

    public boolean addHotel(Hotel newHotel){
        if(listOfHotels.containsKey(newHotel.getId())){
            return false;
        }
        listOfHotels.put(newHotel.getId(), newHotel);
        return true;
    }

    public Map<Integer , Hotel> getListOfHotels(){
        return this.listOfHotels;
    }

}
