package testAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    //Hotel is a schema of different hotels with having additional details as an object

    private int id;
    private String name, facilities;
    private int noOfrooms;
    private Map<Integer , AdditionalDetailsOfHotel> additionalDetails;
    private Map<Customer , String> feedbackList;

    public Hotel(int id , String name , int noOfrooms){
        this.id = id;
        this.name = name;
        this.noOfrooms = noOfrooms;
        this.additionalDetails = new HashMap<>();
        feedbackList = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFacilities() {
        return facilities;
    }

    public Map<Integer , AdditionalDetailsOfHotel> getLocations(){
        return this.additionalDetails;
    }

    public void addLocation(AdditionalDetailsOfHotel newLocation){
        this.additionalDetails.put(newLocation.getId(), newLocation);
    }

    public List<String> getlocations(){
        List<String> locationList = new ArrayList<>();

        for(AdditionalDetailsOfHotel location : this.additionalDetails.values()){
            String locationDetails = location.getPhoneNo() + ", " + location.getAddress() + ", " + location.getRooms();

            locationList.add(locationDetails);
        }
        return locationList;
    }

    public void displayDetails(){
        System.out.println("Hotel Details : ");
        System.out.println("Name of the Hotel : " + name + " Hotel id : " + id + "Hotel facilities : " + facilities);
        System.out.println("Locations : ");
        for(AdditionalDetailsOfHotel location : additionalDetails.values()){
            System.out.print(location + " ");
        }
    }

    public Map<Integer , AdditionalDetailsOfHotel> getDetailsObject(){
        return additionalDetails;
    }

    public int getNoOfrooms() {
        return noOfrooms;
    }

    public Map<Customer, String> getFeedbackList() {
        return feedbackList;
    }

}
