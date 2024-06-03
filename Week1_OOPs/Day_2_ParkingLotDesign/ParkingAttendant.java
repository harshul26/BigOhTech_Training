package Day_2_ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

class ParkingAttendant extends User {
    private List<Integer> paidUserID;

    public ParkingAttendant(String name, int age, int id) {
        super(name, age, id);
        this.paidUserID = new ArrayList<>();
    }
    public List<Integer> getPaidUserId(){
        return paidUserID;
    }
    public void userPaid(int userID) {
        paidUserID.add(userID);
    }
}

