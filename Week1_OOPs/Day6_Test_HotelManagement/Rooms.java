package testAssignment;

public class Rooms {
    private int id , noOfrooms;
    private boolean isFilled;

    public Rooms(int id ){
        this.id = id;
        
        this.isFilled = false; // room is not occupied yet
    }

    public int getId() {
        return id;
    }

    public int getNoOfrooms() {
        return noOfrooms;
    }

    //if the room is filled return true
    public boolean isFilled() {
        return isFilled;
    }

    //if room is empty then occupy the room 
    public boolean occupyTheRoom(){
        if(!isFilled()){
            this.isFilled = true;
            return true;
        }

        return false;
    }

    //empty the occupied room
    public boolean emptyTheRoom(){
        if(isFilled()){
            this.isFilled = false;
            return true;
        }
        return false;
    }

    public String displayDetails(){
        return "Number of Room: " + this.noOfrooms + ", Occupied: " + this.isFilled + "";
    }
    
}
