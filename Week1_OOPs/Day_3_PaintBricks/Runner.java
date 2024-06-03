package Day_3_PaintBrick;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        CountryManagementSystem system = new CountryManagementSystem(5);
        City city1 = new City(1 , "City1");
        City city2 = new City(1 , "City2");
        City city3 = new City(1 , "City3");

        Wall wall1 = new Wall(1);
        Wall wall2 = new Wall(2);
        Wall wall3 = new Wall(3);
        Wall wall4 = new Wall(4);
        Wall wall5 = new Wall(5);

        system.addOwner(new Owner(city1 , new ArrayList<>(Arrays.asList(wall1))));
        system.addOwner(new Owner(city1 , new ArrayList<>(Arrays.asList(wall2))));
        system.addOwner(new Owner(city2 , new ArrayList<>(Arrays.asList(wall3))));
        system.addOwner(new Owner(city3 , new ArrayList<>(Arrays.asList(wall4))));
        system.addOwner(new Owner(city3 , new ArrayList<>(Arrays.asList(wall5))));

        system.paintCity_Wall_Bricks(1, 1, 1, "New Wall!!");

        //for every Owner we can check this.
        Owner own = system.hottestPerson();
        if(own != null){
            System.out.println("Hottest person Id : " + own.getId());
        }
        else{
            System.out.println("no Hottest Person");
        }
    }
    
}
