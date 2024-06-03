package testAssignment;

public class Customer extends Person{
    //Customer is the normal user in the system derives from the person

    private int occupiedRooms;

    public Customer(int pId, int pAge, String pName, String pAddress, String pEmail, Long phoneNo) {
        super(pId, pAge, pName, pAddress, pEmail, phoneNo);
        this.occupiedRooms = 0;
    }

    public int getRoomsOccupy() {
        //returns no. of rooms occupied by the Customer
        return occupiedRooms;
    }

    public void occupyRoom(){
        //occupy a room
        this.occupiedRooms++;
    }

    //Customer can modify it's own details
    public void modifyUserDetails(int id , String name , int age , String address , String email , Long phoneNo){
        if(id != 0){
            this.setpId(id);
        }

        if(name != null){
            this.setpName(name);
        }

        if(age != 0){
            this.setpAge(age);
        }

        if(address != null){
            this.setpAddress(address);
        }

        if(email != null){
            this.setpEmail(email);
        }

        if(phoneNo != 0){
            this.setPhoneNo(phoneNo);
        }
    }
}
