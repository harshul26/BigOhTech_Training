package testAssignment;

public class Administrator extends Person{
    //Admin is the Person who has all the access of the System

    HotelSystem systemManager;
    public Administrator(int pId, int pAge, String pName, String pAddress, String pEmail, Long phoneNo) {
        super(pId, pAge, pName, pAddress, pEmail, phoneNo);
        systemManager = new HotelSystem();
    }

    public HotelSystem getSystemManager(){
        return systemManager;
    }
    
}
