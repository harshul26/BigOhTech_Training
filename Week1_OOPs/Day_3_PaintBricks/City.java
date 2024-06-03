package Day_3_PaintBrick;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    int id ;
    int maxWalls;
    String cityName;
    Map<Integer , Wall> walls;

    public City(){

    }

    public City(int id , String name){
        this.id = id;
        this.cityName = name;
        this.maxWalls = 1;
        walls = new HashMap<>();
    }

    public int getMaxWalls(){
        return maxWalls;
    }

    

    public int totalNoOfBricksInitiated(int wallId){
        return walls.get(wallId).getMaximumBricks();
    }

    public void paintWallBricks(int wallId , String content , int brickid){
        walls.get(wallId).paintBricks(brickid, content);
    }

    public List<List<String>> showContentCityOfWall(int wallId){
        return walls.get(wallId).showContentWall();
    }
    
    public boolean addNewWall(Wall wall){
        if(wall.ifAllBricksOccupies()){
            walls.put(wall.getId() , wall);
            maxWalls++;
            return true;
        }
        return false;
    }
}
