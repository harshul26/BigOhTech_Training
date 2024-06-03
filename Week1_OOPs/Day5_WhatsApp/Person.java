package Day_5_WhatsApp;

public class Person {
    private String name , gender;
    private int age;
    private Long phoneNo;
    

    public Person(String name , int age , String gender , Long phoneNo){
        
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNo = phoneNo;
    }


    public int getAge() {
        return age;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void displayUserInfo(){
        System.out.println(" ===========Details of the User============");
        System.out.println("User-Name : " + name);
        System.out.println("User-Age : " + age);
        System.out.println("User-Gender : " + gender);
        System.out.println("User-PhoneNumber : " + phoneNo);
    }

    
    
}
