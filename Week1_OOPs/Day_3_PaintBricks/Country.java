package Day_3_PaintBrick;

import java.util.ArrayList;
import java.util.List;
public class Country {
    private String name;
    List<City> cities;
    public Country (String name){
        this.name = name; 
        cities = new ArrayList<>();
    }

    public String getCountryName(){
        return this.name;
    }

    public void addCity(City city){
        cities.add(city);
    }
    
}
