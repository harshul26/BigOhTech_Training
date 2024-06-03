package Day_3_PaintBrick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Wall {
    private int maximumBricks;
    private int  id;
    HashMap<Integer , Brick> allocatedBricks; // eachBrick is allocated to respective id inside wall

    public Wall(){

    }

    public Wall(int id){
        this.id = id;
        this.maximumBricks = 90;
        allocatedBricks = new HashMap<>();
    }

    public int getId(){
        return this.id;
    }

    public int getMaximumBricks(){
        return maximumBricks;
    }
    public void paintBricks(int brickId , String comment){
        if(!allocatedBricks.containsKey(brickId)){
            allocatedBricks.put(brickId, new Brick(brickId));
        }

        allocatedBricks.get(brickId).addComments(comment);
    }

    public List<List<String>> showContentWall(){
        List<List<String>> listOfContents = new ArrayList<>();
        for(Brick b : allocatedBricks.values()){
            listOfContents.add(b.showContents());
        }

        return listOfContents;
    }

    public boolean ifAllBricksOccupies(){
        for(Brick b : allocatedBricks.values()){
            if(!b.showContents().isEmpty()){
                return false;
            }
        }
        return true;
    }
    
}
