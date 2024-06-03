package Day_3_PaintBrick;

public class User {
    private String name;
    protected String gender;
    private int age;

    public User(){
        
    }
    public User(String name , int age , String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getUserName(){
        return this.name;
    }

    public int getUserAge(){
        return this.age;
    }

    public String getUserGender(){
        return this.gender;
    }
    
}
