package Day_3_PaintBrick;

import java.util.HashMap;
import java.util.Map;

public class CountryManagementSystem {
    private int maxcity;
    Map<Integer , City> cities;
    Map<Integer , Owner> owners;

    public CountryManagementSystem(int maxcity){
        this.cities = new HashMap<>();
        this.owners = new HashMap<>();
        this.maxcity = maxcity;
    }

    public int getMaxNumberOfCities(){
        return maxcity;
    }

    public int totalNumberOfWallsInitiated(int cityId){
        return cities.get(cityId).getMaxWalls();
    }

    public int numberOfBricksInWalls(int cId , int wId){
        return cities.get(cId).totalNoOfBricksInitiated(wId);
    }

    public void paintCity_Wall_Bricks(int cId , int wId , int bId , String content){
        cities.get(cId).paintWallBricks(wId, content, bId);
    }

    public void addOwner(Owner owner){
        owners.put(owner.getId(), owner);
    }

    public Owner hottestPerson(){
        int maximumBricks = 0;
        Owner winner = null;
        for(Owner own : owners.values()){
            if(maximumBricks < own.noOfBricksRecieved()){
                maximumBricks = own.noOfBricksRecieved();
                winner = new Owner();
            }
        }
        return winner;
    }
}

