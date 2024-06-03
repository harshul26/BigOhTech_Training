package testAssignment;

public class RoomBooking {
    private Customer user;
    private Rooms room;
    private String checkInTime , checkOutTime;

    public RoomBooking(Customer user, Rooms room, String checkInTime, String checkOutTime) {
        
        this.user = user;
        this.room = room;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }
    
    public Person getUser() {
        return user;
    }

    public Rooms getRoom() {
        return room;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public String bookinDetails(){
        return user.displayDetails() + ", Room Details : " + room.displayDetails() + ", Checked in date: " + checkInTime + ", Checked-Out Date: " + checkOutTime + "";
    }
}
