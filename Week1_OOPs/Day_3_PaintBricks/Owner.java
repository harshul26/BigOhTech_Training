package Day_3_PaintBrick;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User{

    int id;
    City city;
    List<Wall> walls;
    List<Brick> getBrick;
    List<Owner> lovers;

    public Owner(){

    }
    public Owner(String name, int age, String gender , int id){
        super(name, age, gender);
        this.id = id;
        walls = new ArrayList<>();
        getBrick = new ArrayList<>();
        lovers = new ArrayList<>();
    }
    public Owner(Owner owner, String name, int age, String gender , int id) {
        this(gender, age, gender , id);
        this.city = owner.city;
        this.walls = owner.walls;
        this.getBrick = owner.getBrick;
        this.lovers = owner.lovers;
    }

    public Owner(City city , List<Wall> walls ){
        this.city = city;
        this.walls = walls;
    }

    public void recieveTheBrick(Brick b){
        getBrick.add(b);
    }

    public int noOfBricksRecieved(){
        return this.getBrick.size();
    }

    public List<Brick> animateBricksOfOwner(){
        return getBrick;
    }

    public void giveBricksTo(Owner owner){
        lovers.add(owner);
    }

    public int getId(){
        return this.id;
    }
}
