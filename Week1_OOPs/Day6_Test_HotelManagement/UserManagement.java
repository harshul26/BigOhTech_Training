package testAssignment;

import java.util.HashMap;
import java.util.Map;

public class UserManagement {
    private Map<Integer , Customer> customers;


    public UserManagement(){
        this.customers = new HashMap<>();
    }

    //adding the user can be done by only Admin
    public boolean addUser(Customer newCustomer , Administrator admin){
        if(customers.containsKey(newCustomer.getpId())){
            return false;
        }
        customers.put(newCustomer.getpId(), newCustomer);
        return true;
    }

    public void displaydetailsOfUsers(){
        for(Person person : customers.values()){
            person.displayDetails();
        }
    }

    //deleting the user can be done by only Admin
    public boolean deleteUser(Person oldCustomer ){
        if(customers.containsKey(oldCustomer.getpId())){
            customers.remove(oldCustomer.getpId());
            return true;
        }
        return false;
    }

    //occupying the room by customer
    public void checkedIn(Customer customer){
        customers.get(customer.getpId()).occupyRoom();
    }

    //if the user is listed in the database
    public boolean isUserAvailable(Customer customer){
        return customers.containsKey(customer.getpId());
    }
}
