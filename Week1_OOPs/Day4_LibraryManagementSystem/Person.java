package Day_4_LibraryManagementSystem;


import java.util.HashMap;

public class Person {
    private String name;
    private int id;
    private Long contact;

    //contructor of Person
    public Person(String name , int id , Long contact){
        this.name = name;
        this.id = id;
        this.contact = contact;
    }

    //Getters of data members of Person
    public int getPersonId(){
        return this.id;
    }

    public String getPersonName(){
        return this.name;
    }

    public Long getPersonContact(){
        return this.contact;
    }
    
    //Details of the Person
    public void showDetails(){
        //display the details 
        //System.out.println("User name: " + name + " Contact: " + contact);
        
    }
    
}
