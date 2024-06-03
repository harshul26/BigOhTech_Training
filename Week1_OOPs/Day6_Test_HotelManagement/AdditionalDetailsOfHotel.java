package testAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  AdditionalDetailsOfHotel{

    //storing the details of the Hotel like address , phone no and list of rooms

    private int id;
    private String phoneNo;
    private String address;
    private Map<Integer , Rooms> rooms; //list of rooms in a hotel at a particular address

    public AdditionalDetailsOfHotel(int id , String phoneNo , String address , String rooms){
        this.id = id;
        this.phoneNo = phoneNo;
        this.address = address;
        this.rooms = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getRooms(){
        List<String> roomList = new ArrayList<>();
        for(Rooms room : rooms.values()){
            roomList.add(room.displayDetails());
        }
        return roomList;
    }

    public void addRoom(Rooms newRoom){
        rooms.put(newRoom.getId(), newRoom);
    }

    public Map<Integer , Rooms> getRoomObjects(){
        return rooms;
    }
    
}
