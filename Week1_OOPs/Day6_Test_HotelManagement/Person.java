package testAssignment;

public class Person {
    //Person is the base class of Customer , Agent , Admin
    private int pId , pAge;
    private String pName , pAddress , pEmail;
    private Long phoneNo;

    public Person(int pId, int pAge, String pName, String pAddress, String pEmail, Long phoneNo) {
        this.pId = pId;
        this.pAge = pAge;
        this.pName = pName;
        this.pAddress = pAddress;
        this.pEmail = pEmail;
        this.phoneNo = phoneNo;
    }

    public int getpId() {
        return pId;
    }

    public int getpAge() {
        return pAge;
    }

    public String getpName() {
        return pName;
    }

    public String getpAddress() {
        return pAddress;
    }

    public String getpEmail() {
        return pEmail;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String displayDetails(){
        return "ID : " + pId + " Name : " + pName + " Age : " + pAge + " Address : " + pAddress + " Email : " + pEmail + " Phone No : " + phoneNo;
    }
    
}
